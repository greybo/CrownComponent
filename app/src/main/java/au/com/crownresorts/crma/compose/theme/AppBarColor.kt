package au.com.crownresorts.crma.compose.theme

import androidx.compose.ui.graphics.Color

data class AppBarColor(
    val background: Color,
    val tint: Color
)

fun appBarColorDefault() = AppBarColor(Color.Unspecified, Color.Unspecified)

fun appBarLight() = AppBarColor(
    background = Grey,
    tint = Black
)

fun appBarDark() = AppBarColor(
    background = Black,
    tint = White
)
