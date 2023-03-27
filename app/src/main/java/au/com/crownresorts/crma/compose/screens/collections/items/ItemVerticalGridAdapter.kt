package au.com.crownresorts.crma.compose.screens.collections.items

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.model.HitModel
import au.com.crownresorts.crma.compose.model.fakeCellList

@ExperimentalFoundationApi
@Composable
fun ItemVerticalGridAdapter(
    list: List<HitModel>,
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
                list[it].hitId
            },
            span = {
                GridItemSpan(1)
            },
        ) { index ->
            val modifier = Modifier
                .aspectRatio(1f)
                .animateItemPlacement(
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
            ItemEntertainmentCell(list[index], modifier)
        }
    }
}


@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreviewItemEntertainmentGrid() {
    ItemVerticalGridAdapter(fakeCellList)
}