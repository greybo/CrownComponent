package au.com.crownresorts.crma.compose.screens.whatson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemDividerComponent
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemIconCategory
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemLargeCellCollection
import au.com.crownresorts.crma.compose.screens.whatson.items.ItemSmallCellCollection

@Composable
fun WhatsonSectionAdapter(
    viewModel: WhatsonColumnViewModel
) {

    val state = viewModel.state.observeAsState()

    Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
        state.value?.forEachIndexed { _, item ->
            when (item) {
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