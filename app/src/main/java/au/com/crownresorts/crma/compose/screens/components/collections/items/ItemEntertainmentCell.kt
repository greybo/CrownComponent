package au.com.crownresorts.crma.compose.screens.components.collections.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import au.com.crownresorts.crma.compose.screens.components.collections.model.EntertainmentCell
import au.com.crownresorts.crma.compose.screens.components.collections.model.cellList
import coil.compose.rememberAsyncImagePainter

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
        contentPadding = PaddingValues(start = edgeDp, end = edgeDp),
        //Distance between items vertical in Vertical Grid
        verticalArrangement = Arrangement.spacedBy(8.dp),
        //Distance between items horizontal in Vertical Grid
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = list.size,
            span = {
                GridItemSpan(1)
            },
        ) { index ->
            val item = list[index]
            EntertainmentCell(item)

        }
    }
}

@Composable
fun EntertainmentCell(item: EntertainmentCell) {
    val context = LocalContext.current

    Column {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val height = constraints.maxWidth / context.resources.displayMetrics.density
            Image(
                painter = rememberAsyncImagePainter(item.urlImage),
                contentDescription = "",
                modifier = Modifier
                    .height(height.dp)
                    .width(height.dp)
            )
        }
        TextCrown(
            text = item.title,
            style = MaterialTheme.typography.bodyLarge,
        )
        TextCrown(
            text = item.body,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
fun PreviewItemCellGridComponent(list: List<String>) {
    ItemEntertainmentCell(cellList)
}