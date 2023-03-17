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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.collections.items.ItemEntertainmentCell
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import au.com.crownresorts.crma.compose.screens.whatson.WhatsonSection

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemLargeCellCollection(model: WhatsonSection.LargeCell, edgeDp: Dp = 16.dp, callback: (String) -> Unit) {

    val list = model.list
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = edgeDp, end = edgeDp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TextCrown(text = model.category)
            if (model.seeAll) Text(
                text = "See All",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 4.dp)
                    .clickable { callback(model.category) }
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
                key = { list.getOrNull(it)?.id ?: 0 },
            ) {
                val item = list[it]
                val modifier = Modifier.animateItemPlacement(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                    /*TweenSpec(
                        300,
                        200,
                        FastOutLinearInEasing
                    )*/
                )

                ItemEntertainmentCell(item, modifier)
//            AnimatedVisibility(
//                visible = true,
//                exit = fadeOut(
//                    animationSpec = TweenSpec(600, 200, FastOutLinearInEasing)
//                )
//            ) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth()
////                    .animateItemPlacement(
////                        animationSpec = spring(
////                            dampingRatio = Spring.DampingRatioMediumBouncy,
////                            stiffness = Spring.StiffnessLow,
////                        )
////                    )
//            ) {
//                Icon(painter = rememberAsyncImagePainter(item.urlImage), contentDescription = "")
//                TextCrown(text = item.title, style = crownTypography.bodySmall)
//            }
//            }
            }
        }
    }

}


