package au.com.crownresorts.crma.compose.theme

import androidx.compose.ui.graphics.Color

data class AppBarColor(
    val background: Color = Color.Unspecified,
    val tint: Color = Color.Unspecified
)

fun appBarColorDefault() = AppBarColor()

fun appBarLight() = AppBarColor(
    background = Grey,
    tint = Black
)

fun appBarDark() = AppBarColor(
    background = Black,
    tint = White
)
