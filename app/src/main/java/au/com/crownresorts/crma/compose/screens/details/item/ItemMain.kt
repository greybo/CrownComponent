package au.com.crownresorts.crma.compose.screens.details.item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.com.crownresorts.crma.compose.screens.details.MainComposeItems

@Composable
fun ItemMainComponent(item: MainComposeItems) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = item.rawValue)
    }
}
@Preview
@Composable
fun PreviewItemMainComponent() {
    ItemMainComponent(MainComposeItems.Color)
}