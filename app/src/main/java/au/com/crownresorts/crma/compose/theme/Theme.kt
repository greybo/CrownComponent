package au.com.crownresorts.crma.compose.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CrownColors(
    val buttonPrimer: ButtonColor,
    val buttonSecondary: ButtonColor,
    val appBar: AppBarColor,
    val divider: Color,
    val textDefault: Color,
    val goldDefault: Color,
    val cardBg: Color,
    val background: Color,
    val iconTint: Color,
    val chipsTextSelect: Color,
    val chipsBgSelect: Color,
    val entertainmentCellText: Color,
)


val LocalCrownColors = staticCompositionLocalOf {
    CrownColors(
        buttonPrimer = buttonDefault(),
        buttonSecondary = buttonDefault(),
        appBar = appBarColorDefault(),
        divider = Color.Unspecified,
        textDefault = Color.Unspecified,
        cardBg = Color.Unspecified,
        background = Color.Unspecified,
        iconTint = Color.Unspecified,
        chipsTextSelect = Color.Unspecified,
        chipsBgSelect = Color.Unspecified,
        goldDefault = Color.Unspecified,
        entertainmentCellText = Color.Unspecified,
    )
}


val LightColors = CrownColors(
    buttonPrimer = buttonPrimaryColor(),
    buttonSecondary = buttonSecondaryColor(),
    appBar = appBarLight(),
    goldDefault = DarkGold,
    textDefault = Charcoal,
    divider = DarkGrey,
    cardBg = White,
    background = White,
    iconTint = Black,
    chipsTextSelect = White,
    chipsBgSelect = DarkGold,
    entertainmentCellText = White,
)


val DarkColors = CrownColors(
    buttonPrimer = buttonPrimaryDark(),
    buttonSecondary = buttonSecondaryDark(),
    appBar = appBarDark(),
    goldDefault = LightGold,
    textDefault = White,
    divider = LightGrey,
    cardBg = Black,
    background = Charcoal, //Black94,
    iconTint = LightGold,
    chipsTextSelect = Black,
    chipsBgSelect = LightGold,
    entertainmentCellText = LightGrey,
)

fun crownColors(isDark: Boolean) = if (isDark) DarkColors else LightColors

@Composable
fun CrownTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(LocalCrownColors provides crownColors(isDark)) {
        MaterialTheme(
            /* colorScheme = ...*/
            shapes = CrownShapes,
            typography = crownTypography,
            content = content
        )
    }
}

object CrownTheme {
    val colors: CrownColors
        @Composable
        get() = LocalCrownColors.current
//    val typography: androidx.compose.material3.Typography
//        @Composable
//        get() = crownTypography
}
