package au.com.crownresorts.crma.compose.toolbar.collapse

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.math.roundToInt

@Composable
fun CollapseToolbar(
    modifier: Modifier = Modifier,
    imageUrlMain: String = "https://picsum.photos/200/200?image=41",
    navigationIcon: ImageVector? = Icons.Default.ArrowBack,
    navigationCallback: (() -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null,
    collapsingTitle: CollapsingTitle? = null,
    scrollBehavior: CustomToolbarScrollBehavior,/*? = null*/
    collapsedElevation: Dp = DefaultCollapsedElevation,
) {
    val collapsedFraction = scrollBehavior.state.collapsedFraction

    val fullyCollapsedTitleScale = collapsingTitle?.let {
        (CollapsedTitleLineHeight.value / it.expandedTextStyle.lineHeight.value)
    } ?: 1f

    val collapsingTitleScale = lerp(1f, fullyCollapsedTitleScale, collapsedFraction)

    val showElevation = (scrollBehavior.state.contentOffset <= 0 && collapsedFraction == 1f)

    val elevationState = animateDpAsState(if (showElevation) collapsedElevation else 0.dp)
    val iconColorState = if (showElevation) Color.Black else Color.White

    Surface(
        modifier = modifier,
        shadowElevation = elevationState.value,
    ) {
        Layout(
            content = {
                if (collapsingTitle != null) {
                    AsyncImage(
                        model = imageUrlMain,
                        contentDescription = "",
                        modifier = Modifier
                            .layoutId(ImageMainId)
                            .fillMaxWidth()
                            .fillMaxHeight(0.4f),
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        modifier = Modifier
                            .layoutId(ExpandedTitleId)
                            .wrapContentHeight(align = Alignment.Top)
                            .graphicsLayer(
                                scaleX = collapsingTitleScale,
                                scaleY = collapsingTitleScale,
                                transformOrigin = TransformOrigin(0f, 0f)
                            ),
                        text = collapsingTitle.titleText,
                        style = collapsingTitle.expandedTextStyle,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .layoutId(CollapsedTitleId)
                            .wrapContentHeight(align = Alignment.Top)
                            .graphicsLayer(
                                scaleX = collapsingTitleScale,
                                scaleY = collapsingTitleScale,
                                transformOrigin = TransformOrigin(0f, 0f)
                            ),
                        text = collapsingTitle.titleText,
                        style = collapsingTitle.expandedTextStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (navigationIcon != null) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .layoutId(NavigationIconId)
                    ) {
                        Icon(
                            imageVector = navigationIcon,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                navigationCallback?.invoke()
                            },
                            tint = iconColorState
                        )
                    }
                }

                if (actions != null) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .layoutId(ActionsId)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = iconColorState
                        )
//                       Text("Button")
                    }
                }
            },
            modifier = modifier.then(Modifier.heightIn(min = MinCollapsedHeight))
        ) { measurables, constraints ->
            val horizontalPaddingPx = HorizontalPadding.toPx()
            val expandedTitleBottomPaddingPx = ExpandedTitleBottomPadding.toPx()

            // Measuring widgets inside toolbar:
            val imageMainPlaceable = measurables.firstOrNull { it.layoutId == ImageMainId }
                ?.measure(
                    constraints.copy(minWidth = 0)
                )

            val navigationIconPlaceable =
                measurables.firstOrNull { it.layoutId == NavigationIconId }
                    ?.measure(constraints.copy(minWidth = 0))

            val actionsPlaceable = measurables.firstOrNull { it.layoutId == ActionsId }
                ?.measure(constraints.copy(minWidth = 0))

            val expandedTitlePlaceable = measurables.firstOrNull { it.layoutId == ExpandedTitleId }
                ?.measure(
                    constraints.copy(
                        maxWidth = (constraints.maxWidth - 2 * horizontalPaddingPx).roundToInt(),
                        minWidth = 0,
                        minHeight = 0
                    )
                )

            val navigationIconOffset = when (navigationIconPlaceable) {
                null -> horizontalPaddingPx
                else -> navigationIconPlaceable.width + horizontalPaddingPx * 2
            }

            val actionsOffset = when (actionsPlaceable) {
                null -> horizontalPaddingPx
                else -> actionsPlaceable.width + horizontalPaddingPx * 2
            }

            val collapsedTitleMaxWidthPx =
                (constraints.maxWidth - navigationIconOffset - actionsOffset) / fullyCollapsedTitleScale

            val collapsedTitlePlaceable =
                measurables.firstOrNull { it.layoutId == CollapsedTitleId }
                    ?.measure(
                        constraints.copy(
                            maxWidth = collapsedTitleMaxWidthPx.roundToInt(),
                            minWidth = 0,
                            minHeight = 0
                        )
                    )

            val collapsedHeightPx = MinCollapsedHeight.toPx()

            var layoutHeightPx = collapsedHeightPx
            // Current coordinates of navigation icon
            val navigationIconX = horizontalPaddingPx.roundToInt()
            val navigationIconY =
                ((collapsedHeightPx - (navigationIconPlaceable?.height ?: 0)) / 2).roundToInt()

            // Current coordinates of actions
            val actionsX = (constraints.maxWidth - (actionsPlaceable?.width
                ?: 0) - horizontalPaddingPx).roundToInt()
            val actionsY = ((collapsedHeightPx - (actionsPlaceable?.height ?: 0)) / 2).roundToInt()

            // Current coordinates of title
            var collapsingTitleY = 0
            var collapsingTitleX = 0

            if (expandedTitlePlaceable != null && collapsedTitlePlaceable != null) {
                // Measuring toolbar collapsing distance
                val heightOffsetLimitPx =
                    imageMainPlaceable!!.height - expandedTitlePlaceable.height - expandedTitleBottomPaddingPx
                scrollBehavior.state.heightOffsetLimit = -heightOffsetLimitPx

                // Toolbar height at fully expanded state
                val fullyExpandedHeightPx = MinCollapsedHeight.toPx() + heightOffsetLimitPx

                // Coordinates of fully expanded title
                val fullyExpandedTitleX = horizontalPaddingPx
                val fullyExpandedTitleY =
                    fullyExpandedHeightPx - expandedTitlePlaceable.height - expandedTitleBottomPaddingPx

                // Coordinates of fully collapsed title
                val fullyCollapsedTitleX = navigationIconOffset
                val fullyCollapsedTitleY =
                    collapsedHeightPx / 2 - CollapsedTitleLineHeight.toPx().roundToInt() / 2

                // Current height of toolbar
                layoutHeightPx = lerp(fullyExpandedHeightPx, collapsedHeightPx, collapsedFraction)

                // Current coordinates of collapsing title
                collapsingTitleX =
                    lerp(fullyExpandedTitleX, fullyCollapsedTitleX, collapsedFraction).roundToInt()
                collapsingTitleY =
                    lerp(fullyExpandedTitleY, fullyCollapsedTitleY, collapsedFraction).roundToInt()
            } else {
                scrollBehavior.state.heightOffsetLimit = -1f
            }

            layout(constraints.maxWidth, layoutHeightPx.roundToInt()) {
                imageMainPlaceable?.placeRelativeWithLayer(
                    x = 0,
                    y = 0,
                    layerBlock = { alpha = 1 - collapsedFraction }
                )
                navigationIconPlaceable?.placeRelative(
                    x = navigationIconX,
                    y = navigationIconY
                )

                actionsPlaceable?.placeRelative(
                    x = actionsX,
                    y = actionsY
                )

                expandedTitlePlaceable?.placeRelativeWithLayer(
                    x = collapsingTitleX,
                    y = collapsingTitleY,
                    layerBlock = { alpha = 1 - collapsedFraction }
                )
                collapsedTitlePlaceable?.placeRelativeWithLayer(
                    x = collapsingTitleX,
                    y = collapsingTitleY,
                    layerBlock = { alpha = collapsedFraction }
                )

            }
        }

    }
}


private fun lerp(a: Float, b: Float, fraction: Float): Float {
    return a + fraction * (b - a)
}

data class CollapsingTitle(
    val titleText: String,
    val expandedTextStyle: TextStyle,
) {

    companion object {
        @Composable
        fun large(titleText: String) =
            CollapsingTitle(titleText, MaterialTheme.typography.headlineLarge)

        @Composable
        fun medium(titleText: String) =
            CollapsingTitle(titleText, MaterialTheme.typography.headlineMedium)
    }

}

private val MinCollapsedHeight = 56.dp
private val HorizontalPadding = 16.dp
private val ExpandedTitleBottomPadding = 8.dp
private val CollapsedTitleLineHeight = 28.sp
private val DefaultCollapsedElevation = 4.dp

private const val ImageMainId = "ImageMainId"
private const val ExpandedTitleId = "expandedTitle"
private const val CollapsedTitleId = "collapsedTitle"
private const val NavigationIconId = "navigationIcon"
private const val ActionsId = "actions"
