package au.com.crownresorts.crma.compose.theme


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
    val divider: Color
)


val LocalCrownColors = staticCompositionLocalOf {
    CrownColors(
        buttonPrimer = buttonDefault(),
        buttonSecondary = buttonDefault(),
        appBar = appBarColorDefault(),
        divider = Color.Unspecified
    )
}


val LightColors = CrownColors(
    buttonPrimer = buttonPrimaryColor(),
    buttonSecondary = buttonSecondaryColor(),
    appBar = appBarLight(),
    divider = DarkGrey
)


val DarkColors = CrownColors(
    buttonPrimer = buttonPrimaryDark(),
    buttonSecondary = buttonSecondaryDark(),
    appBar = appBarDark(),
    divider = LightGrey
)

fun crownColors(isDark: Boolean) = if (isDark) DarkColors else LightColors

@Composable
fun CrownTheme(
    isDark: Boolean,
    /* ... */
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(LocalCrownColors provides crownColors(isDark)) {
        MaterialTheme(
            /* colorScheme = ..., typography = ..., shapes = ... */
            shapes = CrownShapes,
            typography = crownTypography,
            content = content
        )
    }
}

// Use with eg. ExtendedTheme.colors.tertiary
object CrownTheme {
    val colors: CrownColors
        @Composable
        get() = LocalCrownColors.current
//    val typography: androidx.compose.material3.Typography
//        @Composable
//        get() = crownTypography
}
