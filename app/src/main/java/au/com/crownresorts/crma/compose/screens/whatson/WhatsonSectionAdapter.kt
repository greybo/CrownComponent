package au.com.crownresorts.crma.compose.screens.whatson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemDividerComponent
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemIconCategory
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemLargeCellCollection
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemSmallCellCollection

@Composable
fun WhatsonSectionAdapter(
    properties: MutableState<Properties>,
    navController: NavHostController,
    viewModel: WhatsonColumnViewModel = viewModel()
) {
    viewModel.fetchData(properties.value)
    viewModel.navController = navController

    val state = viewModel.state.observeAsState()
    val stateLazy = rememberLazyGridState()
    val list = state.value
    val edgeDp = 16.dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = stateLazy,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = list?.size ?: 0,
            key = {
                list?.getOrNull(it)?.id ?: 0
            },
            span = {
                GridItemSpan(2)
            },
//            contentType = {},
        ) {
            when (val item = list?.getOrNull(it)) {
                is WhatsonSection.Categories -> ItemIconCategory(
                    list = item.list,
                    callback = viewModel::onClick
                )
                is WhatsonSection.LargeCell -> ItemLargeCellCollection(
                    item,
                    callback = viewModel::onClick
                )
                is WhatsonSection.SmallCell -> ItemSmallCellCollection(
                    item,
                    callback = viewModel::onClick
                )
                is WhatsonSection.Divider -> ItemDividerComponent()
                else -> TODO()
            }
        }
    }
}