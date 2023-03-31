package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.screens.tooltip.TooltipOnLongClickExample
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun InfoRowTooltip(
    text: String = "info",
    modifier: Modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
    callback: () -> Unit = {}
) {
    val showTooltip = remember { mutableStateOf(false) }

    TooltipOnLongClickExample(showTooltip) {
        Row(
            modifier = modifier.fillMaxWidth()/*.clickable { callback() }*/,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "icon info",
                modifier = Modifier.clickable { showTooltip.value = true },
                tint = CrownTheme.colors.iconTint
            )
            TextCrown(text = text, style = MaterialTheme.typography.bodySmall)
        }
    }

}

@Preview
@Composable
fun PreviewInfoRow() {
    InfoRowTooltip()
}