package au.com.crownresorts.crma.compose.screens.details.adapter

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import au.com.crownresorts.crma.compose.screens.details.MainComposeItems
import au.com.crownresorts.crma.compose.screens.details.adapter.item.ItemMainComponent

@Composable
fun MainComposeAdapter(list: List<MainComposeItems>) {
    LazyColumn(content = {
        itemsIndexed(items = list) { index, item ->
            ItemMainComponent(item)
        }
    })

}