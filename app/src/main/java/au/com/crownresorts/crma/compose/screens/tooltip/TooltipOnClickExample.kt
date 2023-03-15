package au.com.crownresorts.crma.compose.screens.tooltip

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


/**
 * How to show a Tooltip in AndroidX Jetpack Compose on long click.
 * Usage example.
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
fun TooltipOnLongClickExample(onClick: () -> Unit = {}) {
    // Commonly a Tooltip can be placed in a Box with a sibling
    // that will be used as the 'anchor' for positioning.
    Box(modifier = Modifier.padding(start = 100.dp, top = 100.dp)) {
        val showTooltip = remember { mutableStateOf(false) }

        // Buttons and Surfaces don't support onLongClick out of the box,
        // so use a simple Box with combinedClickable
        Box(
            modifier = Modifier
                .combinedClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(),
                    onClickLabel = "Button action description",
                    role = Role.Button,
                    onClick = { showTooltip.value = true /*onClick*/ },
//                    onLongClick = { showTooltip.value = true },
                ),
        ) {
            Text("Click Me")
        }
        Tooltip(showTooltip) {
//            // Tooltip content goes here.
            Text(
                text = "Tooltip",
                color = CrownTheme.colors.chipsTextSelect,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTooltipOnLongClickExample() {
    CrownTheme {
        TooltipOnLongClickExample()
    }
}