package au.com.crownresorts.crma.compose.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.screens.ComposeTypographyScreen
import au.com.crownresorts.crma.compose.screens.color.ComposeColorScreen
import au.com.crownresorts.crma.compose.screens.components.ComposeComponentScreen
import au.com.crownresorts.crma.compose.screens.components.collections.CardCollectionsComponent
import au.com.crownresorts.crma.compose.screens.main.ComposeDetailsMain
import au.com.crownresorts.crma.compose.screens.main.MainComposeItems

@Preview
@Composable
fun RouterCompose(navController: NavHostController = rememberNavController()) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = RouterScreenType.DetailMain.name
    ) {

        composable(RouterScreenType.DetailMain.name) {
            ComposeDetailsMain(callback = { item ->
                when (item) {
                    MainComposeItems.Color -> navController.navigate(RouterScreenType.Color.name)
                    MainComposeItems.Components -> navController.navigate(RouterScreenType.Components.name)
                    MainComposeItems.Typography -> navController.navigate(RouterScreenType.Typography.name)
                    MainComposeItems.Templates -> navController.navigate(RouterScreenType.Collections.name)
                }
            })
        }
        composable(RouterScreenType.Color.name) { ComposeColorScreen(navController) }
        composable(RouterScreenType.Typography.name) { ComposeTypographyScreen(navController) }
        composable(RouterScreenType.Components.name) { ComposeComponentScreen(navController) }
        composable(RouterScreenType.Collections.name) { CardCollectionsComponent(/*navController*/) }
    }

}

