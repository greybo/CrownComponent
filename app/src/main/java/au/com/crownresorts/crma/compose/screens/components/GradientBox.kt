package au.com.crownresorts.crma.compose.screens.components

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

@Composable
fun GradientBox(height: Dp) {

    Box(
        modifier = Modifier
            .height(height / 2)
            .width(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0f),
                        Color.Black.copy(alpha = 0.75f)
                    ),
//                    startY = 500f,
//                    endY = 1000f
                )
            )
    ) {
    }

}

@Preview
@Composable
fun PreviewGradientComponent() {
    GradientBox(300.dp)
}