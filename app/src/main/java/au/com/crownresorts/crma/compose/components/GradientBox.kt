package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.LightGrey

@Composable
fun GradientBox(
    height: Dp,
    width: Dp,
    start: Color,
    end: Color
) {
    Box(
        modifier = Modifier
            .height(height)
            .width(width)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(start, end),
//                    startY = 500f,
//                    endY = 1000f
                )
            )
    )
}

@Composable
fun GradientHalf(height: Dp, width: Dp) {
    GradientBox(
        height = height / 1.7f,
        width = width,
        start = Color.Black.copy(alpha = 0f),
        end = Color.Black.copy(alpha = 0.75f)
    )
}

@Composable
fun GradientBoxFull(height: Dp, width: Dp, color: Color = LightGrey) {
    GradientBox(
        height = height,
        width = width,
        start = color,
        end = color,
    )
}

@Preview
@Composable
fun PreviewGradientComponent() {
    GradientBox(
        150.dp, 300.dp,
        Color.Black.copy(alpha = 0f),
        Color.Black.copy(alpha = 0.5f)
    )
}