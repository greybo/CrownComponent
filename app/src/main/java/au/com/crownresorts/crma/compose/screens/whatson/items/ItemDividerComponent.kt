package au.com.crownresorts.crma.compose.screens.whatson.items

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun ItemDividerComponent(top: Dp = 24.dp) {
    Divider(
        color = CrownTheme.colors.divider2,
        thickness = 4.dp,
        modifier = Modifier.padding(top = top)
    )
//    Spacer(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(0.5.dp)
//    )
}