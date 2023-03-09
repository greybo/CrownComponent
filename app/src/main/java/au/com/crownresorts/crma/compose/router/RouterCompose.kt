package au.com.crownresorts.crma.compose.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.screens.color.ComposeColorScreen
import au.com.crownresorts.crma.compose.screens.details.ComposeDetailsMain
import au.com.crownresorts.crma.compose.screens.details.MainComposeItems

@Preview
@Composable
fun RouterCompose(navController: NavHostController = rememberNavController()) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = RouterScreenType.DetailMain.name
    ) {

        composable(RouterScreenType.DetailMain.name) {
            ComposeDetailsMain(callback = {item->
                when (item) {
                    MainComposeItems.Color ->  navController.navigate(RouterScreenType.Color.name)
                    MainComposeItems.Components ->  navController.navigate(RouterScreenType.Components.name)
                    MainComposeItems.Typography ->  navController.navigate(RouterScreenType.Typography.name)
                    MainComposeItems.Templates ->  navController.navigate(RouterScreenType.Templates.name)
                }
            })
        }
        composable(RouterScreenType.Color.name) { ComposeColorScreen {} }
        composable(RouterScreenType.Typography.name) { ComposeColorScreen {} }
        composable(RouterScreenType.Components.name) { ComposeColorScreen {} }
        composable(RouterScreenType.Templates.name) { ComposeColorScreen {} }
    }

}

