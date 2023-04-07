package au.com.crownresorts.crma.compose.screens.whatson.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.components.TabLayoutComponent
import au.com.crownresorts.crma.compose.router.RouterScreenType
import au.com.crownresorts.crma.compose.screens.whatson.WhatsonSectionAdapter
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsonMainScreen(navController: NavHostController) {
    val viewModel: WhatsonMainViewModel = viewModel()

    fun onNavigate(type: WhatsonRouterType) {
        val link = when (type) {
            is WhatsonRouterType.Details -> RouterScreenType.Details.name + "/${type.id}"
            is WhatsonRouterType.SeeAll -> RouterScreenType.SeeAll.name + "/${type.category}"
            is WhatsonRouterType.CategoryGroup -> RouterScreenType.SeeAll.name + "/${type.category}"
            is WhatsonRouterType.Search -> RouterScreenType.WhatsonSearch.name
        }
        navController.navigate(link)
    }

    Scaffold(
        topBar = {
            CrownToolbar(toolbarModelDefault() {
                when (it) {
                    ActionButtonType.ArrowBack -> navController.popBackStack()
                    ActionButtonType.Search -> onNavigate(WhatsonRouterType.Search)
                    else -> TODO()
                }
            })
        }) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(color = CrownTheme.colors.background)
        ) {
            TabLayoutComponent(viewModel::changeProperty)
            WhatsonSectionAdapter(viewModel.state.observeAsState(), ::onNavigate)
        }
    }
}

@Preview
@Composable
fun PrevieWhatsonScreen() {
    WhatsonMainScreen(rememberNavController())
}

sealed class WhatsonRouterType {
    data class SeeAll(val category: String) : WhatsonRouterType()
    data class Details(val id: Int) : WhatsonRouterType()
    data class CategoryGroup(val category: String) : WhatsonRouterType()
    object Search : WhatsonRouterType()
}