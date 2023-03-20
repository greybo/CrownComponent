package au.com.crownresorts.crma.compose.screens.whatson.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.TextCrown
import au.com.crownresorts.crma.compose.screens.whatson.CategoriesCell
import au.com.crownresorts.crma.compose.screens.whatson.RouterWhatsonType
import au.com.crownresorts.crma.compose.theme.crownTypography


@Composable
fun ItemIconCategory(
    list: List<CategoriesCell>, edgeDp: Dp = 16.dp,
    callback: (RouterWhatsonType) -> Unit
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 24.dp),
        state = rememberLazyListState(),
//        contentPadding = PaddingValues(start = edgeDp, end = edgeDp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        //Moves away from the right edge  in Horizontal
        contentPadding = PaddingValues(horizontal = edgeDp),
    ) {
        items(
            count = list.size,
            key = { list.getOrNull(it)?.title ?: "0" },
        ) { index ->
            val item = list[index]
//            AnimatedVisibility(
//                visible = true,
//                exit = fadeOut(
//                    animationSpec = TweenSpec(600, 200, FastOutLinearInEasing)
//                )
//            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        callback(RouterWhatsonType.CategoryGroup(item.title))
                    }
//                    .animateItemPlacement(
//                        animationSpec = spring(
//                            dampingRatio = Spring.DampingRatioMediumBouncy,
//                            stiffness = Spring.StiffnessLow,
//                        )
//                    )
            ) {
                Icon(painter = painterResource(id = item.iconRes), contentDescription = "")
                TextCrown(text = item.title, style = crownTypography.bodySmall)
            }
//            }
        }
    }
}

@Preview
@Composable
fun PreviewItemIconCategory() {
    ItemIconCategory(
        list = listOf(
            CategoriesCell("Category1", au.com.crownresorts.crma.R.drawable.ic_dining_transparent),
            CategoriesCell("Category2", au.com.crownresorts.crma.R.drawable.ic_dining_transparent),
            CategoriesCell("Category3", au.com.crownresorts.crma.R.drawable.ic_dining_transparent),
        ),
        callback = {}
    )
}