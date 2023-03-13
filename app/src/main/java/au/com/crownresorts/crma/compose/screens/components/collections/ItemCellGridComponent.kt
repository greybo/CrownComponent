package au.com.crownresorts.crma.compose.screens.components.collections

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
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import coil.compose.rememberAsyncImagePainter

@Composable
fun ItemCellGridComponent(list: List<EntertainmentDataCell>) {

    val spanCount = 2
    LazyVerticalGrid(
        columns = GridCells.Fixed(spanCount),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
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
fun EntertainmentCell(item: EntertainmentDataCell) {
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
    ItemCellGridComponent(fakeList)
}