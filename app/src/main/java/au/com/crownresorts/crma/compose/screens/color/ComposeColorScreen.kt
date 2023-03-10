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
    val list = remember { mutableStateOf(groutList) }
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
        ItemColorComponent(list.value)
    }
}

sealed class ColorData {
    data class ColorDataTitle(val name: String) : ColorData()
    data class ColorDataCell(val name: String, val color: Color) : ColorData()

}


val groutList = listOf(

    ColorData.ColorDataTitle("Crown Colour"),
    ColorData.ColorDataCell(name = "Dark Gold \u2028#7C6F49", color = DarkGold),
    ColorData.ColorDataCell(name = "Light Gold \u2028#B4A169", color = LightGold),

    ColorData.ColorDataTitle("Crown Neutrals"),
    ColorData.ColorDataCell(name = "Black\u2028#000000", color = Black),
    ColorData.ColorDataCell(name = "Charcoal\u2028#222222", color = Charcoal),
    ColorData.ColorDataCell(name = "Dark Grey\u2028#4D4845", color = DarkGrey),
    ColorData.ColorDataCell(name = "Medium Grey\u2028#BAB5B1", color = MediumGrey),
    ColorData.ColorDataCell(name = "Grey\u2028#EBEBEB", color = Grey),
    ColorData.ColorDataCell(name = "Light Grey\u2028#F8F8F8", color = LightGrey),
    ColorData.ColorDataCell(name = "White\u2028#FFFFFF", color = White),

    ColorData.ColorDataTitle("Crown Transparents"),
    ColorData.ColorDataCell(name = "Black 94\u2028#000000 | 94%", color = Black94),
    ColorData.ColorDataCell(name = "Grey 94\u2028#EBEBEB | 94%", color = Grey94),
    ColorData.ColorDataCell(name = "Light Grey 94\u2028#F8F8F8 | 94%", color = LightGrey94),

    ColorData.ColorDataTitle("Crown Member Tiers"),
    ColorData.ColorDataCell(name = "Member\u2028#002D72", color = TierMember),
    ColorData.ColorDataCell(name = "Silver\u2028#A6A9AA", color = TierSilver),
    ColorData.ColorDataCell(name = "Gold\u2028#AB9D62", color = TierGold),
    ColorData.ColorDataCell(name = "Platinum\u2028#6E6C69", color = TierPlatinum),
    ColorData.ColorDataCell(name = "Black\u2028#000000", color = TierBlack),
    ColorData.ColorDataCell(name = "Crystal\u2028#B2CBE0", color = TierCrystal),

    ColorData.ColorDataTitle("Crown Semantic colours"),
    ColorData.ColorDataCell(name = "Error Dark Red \u2028#B00000", color = ErrorDarkRed),
    ColorData.ColorDataCell(name = "Error Light Red \u2028#F08687", color = ErrorLightRed),
    ColorData.ColorDataCell(name = "Success Dark Green \u2028#027200", color = SuccessDarkGreen),
    ColorData.ColorDataCell(name = "Success Light Green \u2028#03B800", color = SuccessLightGreen),
    ColorData.ColorDataCell(name = "Warning Dark Orange \u2028#CB4E00", color = WarningDarkOrange),
    ColorData.ColorDataCell(name = "Warning Light Orange \u2028#FF6200", color = WarningLightOrange),
    ColorData.ColorDataCell(name = "Info Dark Blue \u2028#057CB1", color = InfoDarkBlue),
    ColorData.ColorDataCell(name = "Info Light Blue \u2028#009ADB", color = InfoLightBlue),
)