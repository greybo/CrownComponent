package au.com.crownresorts.crma.compose.screens.whatson.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.screens.whatson.WhatsonSectionAdapter
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonRouterType
import au.com.crownresorts.crma.compose.toolbar.ToolbarSearchComponent

@Composable
fun WhatsonSearchScreen(navController: NavHostController) {

    val viewModel: WhatsonSearchViewModel = viewModel()

    fun onNavigate(type: WhatsonRouterType) {

    }

    Column(modifier = Modifier.fillMaxSize()) {
        ToolbarSearchComponent(
            searchDisplay = "",
            onSearchTextChanged = {},
            onSearchBack = { navController.popBackStack() },
            expandedInitially = false
        )
        WhatsonSectionAdapter(viewModel.state().observeAsState(), ::onNavigate)

    }
}