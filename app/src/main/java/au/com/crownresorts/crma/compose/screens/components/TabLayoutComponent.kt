package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TabLayoutComponent() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC",
        "MARKET",
        "FILMS",
        "BOOKS",
    )
    TabRow(selectedTabIndex = tabIndex) {
        tabData.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                },
                text = {
                    Text(text = text)
                })
        }
    }
}

@Preview
@Composable
fun PreviewTabLayoutComponent() {
    TabLayoutComponent()
}


data class TabScreen(val text: String)
data class TabRowItem(val title: String, val screen: () -> TabScreen, val icon: ImageVector)

val tabRowItems = listOf(
    TabRowItem(
        title = "Tab 1",
        screen = { TabScreen(text = "Tab 1") },
        icon = Icons.Rounded.Place,
    ),
    TabRowItem(
        title = "Tab 2",
        screen = { TabScreen(text = "Tab 2") },
        icon = Icons.Rounded.Search,
    ),
    TabRowItem(
        title = "Tab 3",
        screen = { TabScreen(text = "Tab 3") },
        icon = Icons.Rounded.Star,
    )
)
