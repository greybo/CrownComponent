package au.com.crownresorts.crma.compose.screens.whatson.items

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.components.TextCrown
import au.com.crownresorts.crma.compose.screens.whatson.main.CategoriesCell
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonRouterType
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.theme.crownTypography
import kotlinx.coroutines.launch

@Composable
fun ItemCategorySearch(
    list: List<CategoriesCell>,
    searchCategory: String = "Right name",
    edgeDp: Dp = 16.dp,
    callback: (WhatsonRouterType) -> Unit
) {
    val style = crownTypography.bodySmall
    val (expanded, onExpand) = remember { mutableStateOf(false) }
    val listHandled = remember { mutableStateOf(list) }
    val scope = rememberCoroutineScope()
    val spanCount = 4

    SideEffect {
        scope.launch {
            listHandled.value = if (expanded) {
                list
            } else {
                if (list.size > 4)
                    list.subList(0, 4)
                else list
            }
        }
    }

    AnimatedVisibility(
        visible = listHandled.value.isNotEmpty(),
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it })
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(spanCount),
            state = rememberLazyGridState(),
            contentPadding = PaddingValues(start = edgeDp, end = edgeDp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item(
                key = searchCategory,
                span = { GridItemSpan(spanCount) }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = searchCategory,
                        style = MaterialTheme.typography.titleMedium,
                        color = CrownTheme.colors.textDefault,
                    )
                    Text(
                        text = if (expanded) "Collapse" else "See all",
                        style = MaterialTheme.typography.titleMedium,
                        color = CrownTheme.colors.goldDefault,
                        modifier = Modifier.clickable {
                            onExpand(!expanded)
                        }
                    )
                }
            }
            items(
                count = listHandled.value.size,
                key = { listHandled.value.getOrNull(it)?.title ?: "0" },
                span = { GridItemSpan(1) }
            ) { index ->
                val item = listHandled.value[index]
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable {
                            callback(WhatsonRouterType.CategoryGroup(item.title))
                        }
                ) {
                    Icon(painter = painterResource(id = item.iconRes), contentDescription = "")
                    TextCrown(
                        text = item.title,
                        style = style.copy(letterSpacing = (-0.05).em)
                    ) {
                        padding(all = 0.dp)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewItemCategorySearch() {

    ItemCategorySearch(
        list = listOf(
            CategoriesCell("Category1", R.drawable.ic_dining_transparent),
            CategoriesCell("Category2", R.drawable.ic_dining_transparent),
            CategoriesCell("Category3", R.drawable.ic_dining_transparent),
            CategoriesCell("Category4", R.drawable.ic_dining_transparent),
            CategoriesCell("Category5", R.drawable.ic_dining_transparent),
        ),
        callback = {}
    )
}