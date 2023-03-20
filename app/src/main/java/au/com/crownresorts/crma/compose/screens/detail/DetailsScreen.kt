package au.com.crownresorts.crma.compose.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: DetailsViewModel = viewModel()

    Scaffold(
        topBar = {
            CrownToolbar(toolbarModelDefault(titleText = "Details") {
                if (it == ActionButtonType.ArrowBack) {
                    navController.popBackStack()
                }
            })
        }) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(color = CrownTheme.colors.background)
        ) {
            DetailsSectionAdapter(viewModel)
        }
    }
}

@Preview
@Composable
fun PreviewDetailsScreen() {
    DetailsScreen ()
}
