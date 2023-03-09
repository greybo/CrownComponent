package au.com.crownresorts.crma.compose.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.screens.color.ComposeColorScreen
import au.com.crownresorts.crma.compose.screens.details.ComposeDetailsMain

@Composable
fun RouterCompose(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = ComposeScreenType.DetailMain.rawValue) {
        composable(ComposeScreenType.Color.rawValue) { ComposeColorScreen() }
        composable(ComposeScreenType.DetailMain.rawValue) { ComposeDetailsMain() }
    }
}

@Preview
@Composable
fun PreviewRouterCompose() {
    RouterCompose()
}
