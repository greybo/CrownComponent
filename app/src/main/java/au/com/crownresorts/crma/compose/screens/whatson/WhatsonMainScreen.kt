package au.com.crownresorts.crma.compose.screens.whatson

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
import au.com.crownresorts.crma.compose.screens.components.TabLayoutComponent
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsonMainScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: WhatsonColumnViewModel = viewModel()

    viewModel.navController = navController

    Scaffold(
        topBar = {
            CrownToolbar(toolbarModelDefault() {
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
            TabLayoutComponent(viewModel::changeProperty)
            WhatsonSectionAdapter(viewModel)
        }
    }
}

@Preview
@Composable
fun PreviewWhatsonScreen() {
    WhatsonMainScreen()
}

sealed class RouterWhatsonType {
    data class SeeAll(val category: String) : RouterWhatsonType()
    data class Details(val id: Int) : RouterWhatsonType()
    data class CategoryGroup(val category: String) : RouterWhatsonType()
}