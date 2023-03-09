package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import au.com.crownresorts.crma.compose.screens.details.MainComposeItems
import au.com.crownresorts.crma.compose.screens.details.item.ItemMainComponent

@Composable
fun ComposeColorScreen(callback: () -> Unit) {

    val list = MainComposeItems.values().toList()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            items(count = list.size) {
                ItemMainComponent(item = list[it], callback = {})
            }
        })
}