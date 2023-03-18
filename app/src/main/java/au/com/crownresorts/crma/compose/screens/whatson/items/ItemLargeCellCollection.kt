package au.com.crownresorts.crma.compose.screens.whatson.items

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.collections.items.ItemEntertainmentCell
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import au.com.crownresorts.crma.compose.screens.whatson.RouterWhatsonType
import au.com.crownresorts.crma.compose.screens.whatson.WhatsonSection
import au.com.crownresorts.crma.compose.theme.CrownTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemLargeCellCollection(
    model: WhatsonSection.LargeCell,
    edgeDp: Dp = 16.dp,
    callback: (RouterWhatsonType) -> Unit
) {

    val list = model.list
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val widthCell = screenWidth / 1.3f

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = edgeDp, end = edgeDp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            TextCrown(text = model.category)
            if (model.seeAll) Text(
                text = "See All",
                color = CrownTheme.colors.goldDefault,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 4.dp)
                    .clickable { callback(RouterWhatsonType.SeeAll(model.category)) }
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
//        contentPadding = PaddingValues(start = edgeDp, end = edgeDp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            //Moves away from the right edge  in Horizontal
            contentPadding = PaddingValues(horizontal = edgeDp),
        ) {
            items(
                count = list.size,
                key = { list.getOrNull(it)?.hitId ?: 0 },
            ) {
                val item = list[it]

                val modifier = Modifier
                    .width(widthCell)
                    .aspectRatio(0.7f)
                    .animateItemPlacement(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .clickable {
                        callback(RouterWhatsonType.Details(item.hitId))
                    }

//                AnimatedVisibility(
//                    visible = true,
//                    exit = fadeOut(
//                        animationSpec = TweenSpec(600, 600, FastOutLinearInEasing)
//                    )
//                ) {
                ItemEntertainmentCell(item, modifier)
//                }
            }
        }
    }

}


