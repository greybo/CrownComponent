package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ItemColorComponent(list: List<ColorData>) {

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
            span = { index ->
                val span = when (list[index]) {
                    is ColorData.ColorDataTitle -> 2
                    is ColorData.ColorDataCell -> 1
                }
                GridItemSpan(span)
            },
        ) { index ->
            when (val item = list[index]) {
                is ColorData.ColorDataTitle -> ColorSectionNameComponent(item)
                is ColorData.ColorDataCell -> ColorCellComponent(item)
            }
        }
    }
}

@Composable
fun ColorCellComponent(item: ColorData.ColorDataCell) {
    val context = LocalContext.current

    Column {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val height = constraints.maxWidth / context.resources.displayMetrics.density
            Spacer(
                modifier = Modifier
                    .height(height.dp)
                    .width(height.dp)
                    .background(color = item.color)
            )
        }
        Text(
            text = item.name,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun ColorSectionNameComponent(item: ColorData.ColorDataTitle) {

    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}