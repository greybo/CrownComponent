package au.com.crownresorts.crma.compose.screens.collections.items

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.collections.model.EntertainmentCell
import au.com.crownresorts.crma.compose.screens.collections.model.fakeCellList
import au.com.crownresorts.crma.compose.screens.components.GradientBox
import au.com.crownresorts.crma.compose.theme.CrownTheme
import coil.compose.rememberAsyncImagePainter

@ExperimentalFoundationApi
@Composable
fun ItemEntertainmentCell(
    list: List<EntertainmentCell>,
    edgeDp: Dp = 0.dp
) {

    val spanCount = 2
    LazyVerticalGrid(
        columns = GridCells.Fixed(spanCount),
        state = rememberLazyGridState(),
        //Moves away from the right edge
        contentPadding = PaddingValues(start = edgeDp, end = edgeDp, bottom = 24.dp/*, top = 24.dp*/),
        //Distance between items vertical in Vertical Grid
        verticalArrangement = Arrangement.spacedBy(8.dp),
        //Distance between items horizontal in Vertical Grid
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            count = list.size,
            key = {
                list[it].id
            },
            span = {
                GridItemSpan(1)
            },
        ) { index ->
            val modifier = Modifier.animateItemPlacement(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
                /*TweenSpec(
                    300,
                    200,
                    FastOutLinearInEasing
                )*/
            )
            EntertainmentCell(list[index], modifier)
        }
    }
}

@Composable
private fun EntertainmentCell(item: EntertainmentCell, modifier: Modifier) {
    val context = LocalContext.current

    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        context.resources.displayMetrics.density

        Image(
            painter = rememberAsyncImagePainter(item.urlImage),
            contentDescription = "",
            modifier = Modifier.aspectRatio(1f)
        )
        GradientBox(maxWidth)
        Column(modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                color = CrownTheme.colors.entertainmentCellText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = item.body,
                style = MaterialTheme.typography.bodySmall,
                color = CrownTheme.colors.entertainmentCellText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewItemEntertainmentGrid() {
    ItemEntertainmentCell(fakeCellList)
}