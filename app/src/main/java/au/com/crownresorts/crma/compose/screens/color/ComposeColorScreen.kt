package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.theme.DarkGold
import au.com.crownresorts.crma.compose.theme.LightGold
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@Composable
fun ComposeColorScreen(navController: NavHostController) {
    val list = remember { mutableStateOf(color) }
    val toolbarModel = toolbarModelDefault(
        titleText = "Color",
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.ArrowBack -> navController.popBackStack()
            else -> TODO()
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {

        CrownToolbar(toolbarModel)

        list.value.forEach { item ->
            ItemColorComponent(item)
        }
    }
}

data class ColorDataCell(val name: String, val color: Color)
data class ColorGrout(val title: String, val list: List<ColorDataCell>)

val color = listOf(
    ColorGrout(
        title = "Crown Colour",
        list = listOf(
            ColorDataCell(name = " Dark Gold \u2028#7C6F49", color = DarkGold),
            ColorDataCell(name = " Light Gold \u2028#B4A169", color = LightGold),
            ColorDataCell(name = " Light Gold \u2028#B4A169", color = LightGold),
        )
    )
)