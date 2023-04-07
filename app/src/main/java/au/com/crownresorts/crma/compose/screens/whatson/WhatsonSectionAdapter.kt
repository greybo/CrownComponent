package au.com.crownresorts.crma.compose.screens.whatson

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.whatson.items.*
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonRouterType
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonSection

@Composable
fun WhatsonSectionAdapter(
    state: State<List<WhatsonSection>?>,
    onNavigate: (WhatsonRouterType) -> Unit
) {
    val edgeDp: Dp = 16.dp

    state.value?.forEachIndexed { _, item ->
        when (item) {
            is WhatsonSection.Categories -> ItemCategoryMain(
                list = item.list,
                edgeDp = edgeDp,
                callback = onNavigate
            )
            is WhatsonSection.LargeCell -> ItemLargeCellCollection(
                item,
                edgeDp = edgeDp,
                callback = onNavigate
            )
            is WhatsonSection.SmallCell -> ItemSmallCellCollection(
                item,
                edgeDp = edgeDp,
                callback = onNavigate
            )
            is WhatsonSection.Divider -> ItemDividerComponent()
            is WhatsonSection.SearchCategories -> ItemCategorySearch(
                list = item.list,
                edgeDp = edgeDp,
                callback = onNavigate
            )
            is WhatsonSection.SearchResult -> ItemSearchResult(
                item,
                edgeDp = edgeDp,
                callback = onNavigate
            )
            else -> TODO()
        }
    }
}