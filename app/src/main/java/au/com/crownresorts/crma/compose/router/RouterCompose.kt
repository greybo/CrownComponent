package au.com.crownresorts.crma.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.router.ComposeScreenType
import au.com.crownresorts.crma.compose.screens.ComposeDetailsMain
import au.com.crownresorts.crma.compose.screens.color.ComposeColorScreen

@Composable
fun RouterCompose(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = ComposeScreenType.DetailMain.rawValue) {
        composable(ComposeScreenType.Color.rawValue) { ComposeColorScreen() }
        composable(ComposeScreenType.DetailMain.rawValue) { ComposeDetailsMain() }
    }
}

