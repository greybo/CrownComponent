package au.com.crownresorts.crma.compose.toolbar.collapse

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.crownresorts.crma.compose.components.GradientHalf
import au.com.crownresorts.crma.compose.model.HitModel
import coil.compose.AsyncImage
import kotlin.math.roundToInt

@Composable
fun CollapseToolbar(
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector? = Icons.Default.ArrowBack,
    navigationCallback: (() -> Unit)? = null,
    collapsingData: HitModel? = null,
    scrollBehavior: CustomToolbarScrollBehavior,
    collapsedElevation: Dp = DefaultCollapsedElevation,
) {
    val collapsedFraction = scrollBehavior.state.collapsedFraction

    val collapsingTitle = MaterialTheme.typography.headlineLarge

    val fullyCollapsedTitleScale = CollapsedTitleLineHeight.value / collapsingTitle.lineHeight.value

    val collapsingTitleScale = lerp(1f, fullyCollapsedTitleScale, collapsedFraction)

    val showElevation = (scrollBehavior.state.contentOffset <= 0 && collapsedFraction > 0.99f)

    val elevationState = animateDpAsState(if (showElevation) collapsedElevation else 0.dp)
    val iconColorState = if (showElevation) Color.Black else Color.White
    val localDensity = LocalDensity.current

    Surface(
        modifier = modifier,
        shadowElevation = elevationState.value,
    ) {
        Layout(
            content = {
                val columnHeightDp = remember { mutableStateOf(0.dp) }
                val columnWidthDp = remember { mutableStateOf(0.dp) }
                Box(
                    modifier = Modifier
                        .layoutId(ImageMainId)
                        .fillMaxWidth()
                        .aspectRatio(1.2f)
                        .onGloballyPositioned { coordinates ->
                            with(localDensity) {
                                columnHeightDp.value = coordinates.size.height.toDp()
                                columnWidthDp.value = coordinates.size.width.toDp()
                            }
                        },
                    contentAlignment = Alignment.BottomStart
                ) {
                    AsyncImage(
                        model = collapsingData?.urlImage,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    GradientHalf(columnHeightDp.value, columnWidthDp.value)
                }
                //-----------------------------------------------------------
                // Toolbar blur component
                Box(
                    modifier = Modifier
                        .layoutId(GradientTopId)
                        .fillMaxWidth()
                        .height(MinCollapsedHeight)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.2f),
                                    Color.Black.copy(alpha = 0.2f)
                                ),
                            )
                        )
                )
                //-----------------------------------------------------------
                // Title text
                if (collapsingData?.title != null) {
                    Text(
                        modifier = Modifier
                            .layoutId(ExpandedTitleId)
                            .wrapContentHeight(align = Alignment.Top)
                            .graphicsLayer(
                                scaleX = collapsingTitleScale,
                                scaleY = collapsingTitleScale,
                                transformOrigin = TransformOrigin(0f, 0f)
                            ),
                        text = collapsingData.title ,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 2,
                        color = Color.White,
                        overflow = TextOverflow.Ellipsis
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
                        text = collapsingData.title,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = iconColorState
                    )
                }
                //-----------------------------------------------------
                TextBodyComponent(collapsingTitleScale, collapsingData)

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
            },
            modifier = modifier.then(Modifier.heightIn(min = MinCollapsedHeight))
        ) { measurables, constraints ->
            val horizontalPaddingPx = HorizontalPadding.toPx()
            val bottomPaddingPx = ExpandedTitleBottomPadding.toPx()

            // Measuring widgets inside toolbar:
            val imageMainPlaceable = measurables.firstOrNull { it.layoutId == ImageMainId }
                ?.measure(
                    constraints.copy(minWidth = 0)
                )
            val gradientTopPlaceable = measurables.firstOrNull { it.layoutId == GradientTopId }
                ?.measure(
                    constraints.copy(minWidth = 0)
                )

            val navigationIconPlaceable =
                measurables.firstOrNull { it.layoutId == NavigationIconId }
                    ?.measure(constraints.copy(minWidth = 0))

            val expandedTitlePlaceable = measurables.firstOrNull { it.layoutId == ExpandedTitleId }
                ?.measure(
                    constraints.copy(
                        maxWidth = (constraints.maxWidth - 2 * horizontalPaddingPx).roundToInt(),
                        minWidth = 0,
                        minHeight = 0
                    )
                )
            val bodyPlaceable = measurables.firstOrNull { it.layoutId == BodyId }
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

            val collapsedTitleMaxWidthPx =
                (constraints.maxWidth - navigationIconOffset - horizontalPaddingPx) / fullyCollapsedTitleScale

            val collapsedTitlePlaceable =
                measurables.firstOrNull { it.layoutId == CollapsedTitleId }
                    ?.measure(
                        constraints.copy(
                            maxWidth = collapsedTitleMaxWidthPx.roundToInt(),
                            minWidth = 0,
                            minHeight = 0
                        )
                    )

            val minCollapsedHeightPx = MinCollapsedHeight.toPx()

            var layoutHeightPx = minCollapsedHeightPx
            // Current coordinates of navigation icon
            val navigationIconX = horizontalPaddingPx.roundToInt()
            val navigationIconY =
                ((minCollapsedHeightPx - (navigationIconPlaceable?.height ?: 0)) / 2).roundToInt()

            // Current coordinates of title
            var collapsingTitleY = 0
            var collapsingTitleX = 0
            val bodyTextHeight = bodyPlaceable?.height ?: 0
            val imageHeight = imageMainPlaceable?.height ?: 0

            if (expandedTitlePlaceable != null && collapsedTitlePlaceable != null) {
                // Measuring toolbar collapsing distance
                val heightOffsetLimitPx = imageHeight - minCollapsedHeightPx
                scrollBehavior.state.heightOffsetLimitPx = -heightOffsetLimitPx

                // Toolbar height at fully expanded state
                val fullyExpandedHeightPx = minCollapsedHeightPx + heightOffsetLimitPx

                // Coordinates of fully expanded title
                val fullyExpandedTitleX = horizontalPaddingPx
                val fullyExpandedTitleY =
                    fullyExpandedHeightPx - expandedTitlePlaceable.height - bodyTextHeight - bottomPaddingPx

                // Coordinates of fully collapsed title
                val fullyCollapsedTitleX = navigationIconOffset
                val fullyCollapsedTitleY =
                    minCollapsedHeightPx / 2 - CollapsedTitleLineHeight.toPx().roundToInt() / 2

                // Current height of toolbar
                layoutHeightPx =
                    lerp(fullyExpandedHeightPx, minCollapsedHeightPx, collapsedFraction)

                // Current coordinates of collapsing title
                collapsingTitleX =
                    lerp(fullyExpandedTitleX, fullyCollapsedTitleX, collapsedFraction).roundToInt()
                collapsingTitleY =
                    lerp(fullyExpandedTitleY, fullyCollapsedTitleY, collapsedFraction).roundToInt()
            } else {
                scrollBehavior.state.heightOffsetLimitPx = -1f
            }

            layout(constraints.maxWidth, layoutHeightPx.roundToInt()) {
                imageMainPlaceable?.placeRelativeWithLayer(
                    x = 0,
                    y = 0,
                    layerBlock = { alpha = 1 - collapsedFraction }
                )

                gradientTopPlaceable?.placeRelativeWithLayer(
                    x = 0,
                    y = 0,
                    layerBlock = { alpha = if (showElevation) 0f else 1f }
                )
                navigationIconPlaceable?.placeRelative(
                    x = navigationIconX,
                    y = navigationIconY
                )

                expandedTitlePlaceable?.placeRelativeWithLayer(
                    x = collapsingTitleX,
                    y = collapsingTitleY,
                    layerBlock = { alpha = 1 - collapsedFraction }
                )
                bodyPlaceable?.placeRelativeWithLayer(
                    x = collapsingTitleX,
                    y = collapsingTitleY + (expandedTitlePlaceable?.height ?: 0),
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

@Composable
private fun TextBodyComponent(
    collapsingTitleScale: Float,
    collapsingData: HitModel?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(BodyId)
            .wrapContentHeight(align = Alignment.Top)
            .graphicsLayer(
                scaleX = collapsingTitleScale,
                scaleY = collapsingTitleScale,
                transformOrigin = TransformOrigin(0f, 0f)
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(end = 8.dp),
                text = "City name",//collapsingData?.body ?: "",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(start = 8.dp),
                text = "Main category",//collapsingData?.body ?: "",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(end = 8.dp),
                text = "Street number/name",//collapsingData?.body ?: "",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(start = 8.dp),
                text = "Price Point",//collapsingData?.body ?: "",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
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
private val ExpandedTitleBottomPadding = 16.dp
private val CollapsedTitleLineHeight = 28.sp
private val DefaultCollapsedElevation = 4.dp

private const val GradientTopId = "GradientTopId"
private const val ImageMainId = "ImageMainId"
private const val ExpandedTitleId = "expandedTitle"
private const val BodyId = "expandedBodyId"
private const val CollapsedTitleId = "collapsedTitle"
private const val NavigationIconId = "navigationIcon"
private const val ActionsId = "actions"
