package au.com.crownresorts.crma.compose.screens.color

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.theme.*
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

        Column( modifier = Modifier.fillMaxSize()
//                .verticalScroll(rememberScrollState())
        ) {
            list.value.forEach { item ->
                ItemColorComponent(item)
            }
        }

    }
}

data class ColorDataCell(val name: String, val color: Color)
data class ColorGrout(val title: String, val list: List<ColorDataCell>)

val color = listOf(
    ColorGrout(
        title = "Crown Colour",
        list = listOf(
            ColorDataCell(name = "Dark Gold \u2028#7C6F49", color = DarkGold),
            ColorDataCell(name = "Light Gold \u2028#B4A169", color = LightGold),
        )
    ),
    ColorGrout(
        title = "Crown Neutrals",
        list = listOf(
            ColorDataCell(name = "Black\u2028#000000", color = Black),
            ColorDataCell(name = "Charcoal\u2028#222222", color = Charcoal),
            ColorDataCell(name = "Dark Grey\u2028#4D4845", color = DarkGrey),
            ColorDataCell(name = "Medium Grey\u2028#BAB5B1", color = MediumGrey),
            ColorDataCell(name = "Grey\u2028#EBEBEB", color = Grey),
            ColorDataCell(name = "Light Grey\u2028#F8F8F8", color = LightGrey),
            ColorDataCell(name = "White\u2028#FFFFFF", color = White),
        )
    ),
    ColorGrout(
        title = "Crown Transparents",
        list = listOf(
            ColorDataCell(name = "Black 94\u2028#000000 | 94%", color = Black94),
            ColorDataCell(name = "Grey 94\u2028#EBEBEB | 94%", color = Grey94),
            ColorDataCell(name = "Light Grey 94\u2028#F8F8F8 | 94%", color = LightGrey94),
        )
    ),
    ColorGrout(
        title = "Crown Member Tiers",
        list = listOf(
            ColorDataCell(name = "Member\u2028#002D72", color = TierMember),
            ColorDataCell(name = "Silver\u2028#A6A9AA", color = TierSilver),
            ColorDataCell(name = "Gold\u2028#AB9D62", color = TierGold),
            ColorDataCell(name = "Platinum\u2028#6E6C69", color = TierPlatinum),
            ColorDataCell(name = "Black\u2028#000000", color = TierBlack),
            ColorDataCell(name = "Crystal\u2028#B2CBE0", color = TierCrystal),
        )
    ),
    ColorGrout(
        title = "Crown Semantic colours",
        list = listOf(
            ColorDataCell(name = "Error Dark Red \u2028#B00000", color = ErrorDarkRed),
            ColorDataCell(name = "Error Light Red \u2028#F08687", color = ErrorLightRed),
            ColorDataCell(name = "Success Dark Green \u2028#027200", color = SuccessDarkGreen),
            ColorDataCell(name = "Success Light Green \u2028#03B800", color = SuccessLightGreen),
            ColorDataCell(name = "Warning Dark Orange \u2028#CB4E00", color = WarningDarkOrange),
            ColorDataCell(name = "Warning Light Orange \u2028#FF6200", color = WarningLightOrange),
            ColorDataCell(name = "Info Dark Blue \u2028#057CB1", color = InfoDarkBlue),
            ColorDataCell(name = "Info Light Blue \u2028#009ADB", color = InfoLightBlue),
        )
    )
)