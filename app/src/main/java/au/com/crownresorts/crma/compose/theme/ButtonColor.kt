package au.com.crownresorts.crma.compose.theme

import androidx.compose.ui.graphics.Color

data class ButtonColor(
    val bg: Color,
    val text: Color,
    val border: Color,
    val disableBg: Color,
    val disableText: Color,
    val disableBorder: Color,
    )


 fun buttonDefault() = ButtonColor(
    bg = Color.Unspecified,
    text = Color.Unspecified,
    border = Color.Unspecified,
    disableBg = Color.Unspecified,
    disableText = Color.Unspecified,
    disableBorder = Color.Unspecified,
)


 fun buttonSecondaryColor() = ButtonColor(
    bg = White,
    text = DarkGold,
    disableBg = White,
    disableText = MediumGrey,
    border = DarkGold,
    disableBorder = MediumGrey,
)

 fun buttonPrimaryColor() = ButtonColor(
    bg = DarkGold,
    text = White,
    border = Color.Unspecified,
    disableBg = MediumGrey,
    disableText = Charcoal,
    disableBorder = Color.Unspecified,
)

 fun buttonSecondaryDark() = ButtonColor(
    bg = Black,
    text = LightGold,
    border = LightGold,
    disableBg = Black,
    disableText = MediumGrey,
    disableBorder = MediumGrey,
)

 fun buttonPrimaryDark() = ButtonColor(
    bg = LightGold,
    text = Charcoal,
    disableBg = MediumGrey,
    disableText = Charcoal,
    border = Color.Unspecified,
    disableBorder = Color.Unspecified,
)