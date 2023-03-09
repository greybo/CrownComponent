package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@Composable
fun ComposeColorScreen(navController: NavHostController) {

    val toolbarModel = toolbarModelDefault(
        titleText = "Color",
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.ArrowBack -> navController.popBackStack()
            else -> TODO()
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        CrownToolbar(toolbarModel)
        Text(
            text = "Color",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}