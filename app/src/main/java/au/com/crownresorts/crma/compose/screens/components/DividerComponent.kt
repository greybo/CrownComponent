package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun DividerComponent(modifier: Modifier = Modifier) {
    Divider(color = CrownTheme.colors.divider, thickness = Dp.Hairline)
//    Spacer(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(0.5.dp)
//    )
}