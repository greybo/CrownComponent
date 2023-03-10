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
    val cardBg: Color,
    val background: Color,
    val iconTint: Color,
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
    )
}


val LightColors = CrownColors(
    buttonPrimer = buttonPrimaryColor(),
    buttonSecondary = buttonSecondaryColor(),
    appBar = appBarLight(),
    divider = DarkGrey,
    textDefault = Charcoal,
    cardBg = White,
    background = White,
    iconTint = Black,
)


val DarkColors = CrownColors(
    buttonPrimer = buttonPrimaryDark(),
    buttonSecondary = buttonSecondaryDark(),
    appBar = appBarDark(),
    divider = LightGrey,
    textDefault = White,
    cardBg = Charcoal,
    background = Black94,
    iconTint = LightGold,
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
