package au.com.crownresorts.crma.compose.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class CrownColors(
    val buttonPrimer: ButtonColor,
    val buttonSecondary: ButtonColor,
    val appBar: AppBarColor
)


val LocalCrownColors = staticCompositionLocalOf {
    CrownColors(
        buttonPrimer = buttonDefault(),
        buttonSecondary = buttonDefault(),
        appBar = appBarColorDefault()
    )
}


val LightColors = CrownColors(
    buttonPrimer = buttonPrimaryColor(),
    buttonSecondary = buttonSecondaryColor(),
    appBar = appBarLight()
)


val DarkColors = CrownColors(
    buttonPrimer = buttonPrimaryDark(),
    buttonSecondary = buttonSecondaryDark(),
    appBar = appBarDark(),
)

@Composable
fun CrownTheme(
    isDark: Boolean,
    /* ... */
    content: @Composable () -> Unit
) {
    val extendedColors = if (isDark) DarkColors else LightColors
    CompositionLocalProvider(LocalCrownColors provides extendedColors) {
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
