package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.whatson.Properties
import au.com.crownresorts.crma.compose.theme.Black
import au.com.crownresorts.crma.compose.theme.Grey
import au.com.crownresorts.crma.compose.theme.White

@Composable
fun TabLayoutComponent(propertyCurrent: MutableState<Properties>) {
//    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = Properties.values()
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp)),
        indicator = {
            TabRowDefaults.Indicator(
                height = 50.dp,
                modifier = Modifier
                    .tabIndicatorOffset(it[tabIndex]),
                color = White.copy(alpha = 0.4f)
            )
        },
//        divider = { },
        tabs = {
            tabData.forEachIndexed { index, type ->
                Tab(
                    selected = tabIndex == index,
                    modifier = Modifier.background(color = if (tabIndex == index) White else Grey),
                    onClick = {
//                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                        tabIndex = index
                        propertyCurrent.value = type
                    },
                    text = {
                        Text(text = type.name)
                    },
                    selectedContentColor = Black,
                    unselectedContentColor = Black,
                )
            }
        })
}

@Preview
@Composable
fun PreviewTabLayoutComponent() {
    TabLayoutComponent(remember { mutableStateOf(Properties.Sydney) })
}

