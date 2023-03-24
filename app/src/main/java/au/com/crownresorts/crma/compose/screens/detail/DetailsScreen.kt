package au.com.crownresorts.crma.compose.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.toolbar.collapse.CollapseToolbar
import au.com.crownresorts.crma.compose.toolbar.collapse.CollapsingTitle
import au.com.crownresorts.crma.compose.toolbar.collapse.rememberToolbarScrollBehavior

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: DetailsViewModel = viewModel()
    val scrollBehavior = rememberToolbarScrollBehavior()
    val hit = viewModel.state.observeAsState()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CollapseToolbar(
                imageUrlMain = hit.value?.urlImage ?: "",
                navigationCallback = { navController.popBackStack() },
//                actions = getActionsSlot(),
                collapsingData = hit.value,
                collapsingTitle = CollapsingTitle.large(hit.value?.title ?: ""),
                scrollBehavior = scrollBehavior
            )
        },
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(contentPadding)) {
            scrollableItemsForSample()
        }
    }
}

//private fun getActionsSlot(): (@Composable RowScope.() -> Unit) {
//    return {
//
//    }
//}

private fun LazyListScope.scrollableItemsForSample() {
    for (i in 0..100) {
        item("scroll_test_$i") {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), text = "Item for scroll testing #$i"
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetailsScreen() {
    DetailsScreen()
}
