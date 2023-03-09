package au.com.crownresorts.crma.compose.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.details.item.ItemMainComponent
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar

@Composable
fun ComposeDetailsMain(viewModel: DetailsMainViewModel = viewModel()) {
    val list = viewModel.state.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        CrownToolbar()
        LazyColumn(content = {
            itemsIndexed(items = list.value ?: emptyList()) { index, item ->
                ItemMainComponent(item)
            }
        })
    }

}

@Preview
@Composable
fun PreviewComposeDetailsMain() {
    ComposeDetailsMain()
}
