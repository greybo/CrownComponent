package au.com.crownresorts.crma.compose.screens.main.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import au.com.crownresorts.crma.compose.screens.main.MainComposeItems

@Composable
fun ItemMainComponent(item: MainComposeItems, callback: (MainComposeItems) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { callback(item) }) {
        TextCrown(
            text = item.rawValue,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp/*, bottom = 8.dp*/)
        )
//        Text(
//            text = item.rawValue,
//            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
//        )
    }
}

@Preview
@Composable
fun PreviewItemMainComponent() {
    ItemMainComponent(MainComposeItems.Color, {})
}