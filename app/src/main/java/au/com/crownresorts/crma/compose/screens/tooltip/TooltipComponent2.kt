package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tooltip2(showTooltip: MutableState<Boolean> = mutableStateOf(true)) {
    if (showTooltip.value) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = { /*TODO*/ },
            modifier = Modifier
                .combinedClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(),
//                    onClickLabel = "Button action description",
//                    role = Role.Button,
                    onClick = {
                        showTooltip.value = false
                    }
                )
        ) {
            Text(text = "Tooltip", modifier = Modifier.padding(4.dp))
        }
    }
}


@Preview
@Composable
fun PreviewTooltip2() {
    Tooltip2()
}