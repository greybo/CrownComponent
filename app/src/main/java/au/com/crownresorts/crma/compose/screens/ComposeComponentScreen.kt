package au.com.crownresorts.crma.compose.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@Composable
fun ComposeComponentScreen(navController: NavHostController = rememberNavController()) {

    val toolbarModel = toolbarModelDefault(
        titleText = "Component",
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.ArrowBack -> navController.popBackStack()
            else -> TODO()
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        CrownToolbar(toolbarModel)
        HorizontalTitle()

    }
}

@Preview
@Composable
fun PreviewComponentScreen() {
    ComposeComponentScreen()
}