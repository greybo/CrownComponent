package au.com.crownresorts.crma.compose.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.ComposeExampleActivity
import au.com.crownresorts.crma.compose.main.item.ItemMainComponent
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.homeActionDefault
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@Composable
fun ComposeDetailsMain(viewModel: DetailsMainViewModel = viewModel(), callback: (MainComposeItems) -> Unit) {
    val activity = (LocalContext.current as ComposeExampleActivity)
    val list = viewModel.state.observeAsState()

    val toolbarModel = toolbarModelDefault(
        titleText = "Details Main",
        homeIcon = homeActionDefault(ActionButtonType.Close),
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.Close -> activity.finish()
            else -> TODO()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CrownToolbar(toolbarModel)

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
