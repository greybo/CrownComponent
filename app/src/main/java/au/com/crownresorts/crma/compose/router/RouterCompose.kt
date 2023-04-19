package au.com.crownresorts.crma.compose.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import au.com.crownresorts.crma.compose.main.ComposeDetailsMain
import au.com.crownresorts.crma.compose.main.MainComposeItems
import au.com.crownresorts.crma.compose.screens.ComposeComponentScreen
import au.com.crownresorts.crma.compose.screens.ComposeTypographyScreen
import au.com.crownresorts.crma.compose.screens.collections.CardCollectionsComponent
import au.com.crownresorts.crma.compose.screens.color.ComposeColorScreen
import au.com.crownresorts.crma.compose.screens.detail.DetailsScreen
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonMainScreen
import au.com.crownresorts.crma.compose.screens.whatson.search.WhatsonSearchScreen

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
                    MainComposeItems.Collections -> navController.navigate(RouterScreenType.Collections.name)
                    MainComposeItems.Whatson -> navController.navigate(RouterScreenType.Whatson.name)
                }
            })
        }
        composable(RouterScreenType.Color.name) { ComposeColorScreen(navController) }
        composable(RouterScreenType.Typography.name) { ComposeTypographyScreen(navController) }
        composable(RouterScreenType.Components.name) { ComposeComponentScreen(navController) }
        composable(RouterScreenType.Collections.name) { CardCollectionsComponent(/*navController*/) }
        composable(RouterScreenType.WhatsonSearch.name) { WhatsonSearchScreen(navController) }
        composable(route = RouterScreenType.Whatson.name) { WhatsonMainScreen(navController) }
        composable(
            route = RouterScreenType.Details.name + "/{hitId}",
        ) {
            DetailsScreen(navController)
        }
        composable(
            route = RouterScreenType.SeeAll.name + "/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
                defaultValue = "user1234"
            }
            )
        ) {
//            CategoriesScreen(navController)
        }
    }

}

