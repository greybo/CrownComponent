package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemColorComponent(item: ColorGrout) {
    Card(
        modifier = Modifier.padding(all = 8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(all = 8.dp),
        )
        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 128.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(item.list.size) { index ->
                ColorCellComponent(item.list[index])
            }
        }
    }

}

@Composable
fun ColorCellComponent(item: ColorDataCell) {
    Card(
        modifier = Modifier
            .background(color = item.color)
            .padding(all = 16.dp)
    ) {

    }
}