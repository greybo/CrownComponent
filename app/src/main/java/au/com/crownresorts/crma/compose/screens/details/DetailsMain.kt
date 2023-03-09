package au.com.crownresorts.crma.compose.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.details.item.ItemMainComponent
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar

@Composable
fun ComposeDetailsMain(viewModel: DetailsMainViewModel = viewModel(), callback: (MainComposeItems) -> Unit) {

    val list = viewModel.state.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        CrownToolbar()
        Spacer(modifier = Modifier.padding(bottom = 24.dp))
        LazyColumn(content = {
            itemsIndexed(items = list.value ?: emptyList()) { index, item ->
                ItemMainComponent(item, callback)
            }
        })
    }

}

@Preview
@Composable
fun PreviewComposeDetailsMain() {
    ComposeDetailsMain(callback = {})
}
