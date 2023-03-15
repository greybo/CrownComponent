package au.com.crownresorts.crma.compose.screens.tooltip

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
fun TooltipOnLongClickExample(
    showTooltip2: MutableState<Boolean>? = null,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
//    Box(/*modifier = modifier*/) {
        val showTooltip = showTooltip2 ?: remember { mutableStateOf(false) }
        val interactionSource = remember { MutableInteractionSource() }
        val indication = rememberRipple()
        val _modifier = remember {
            if (showTooltip2 == null) {
                modifier.combinedClickable(
                    interactionSource = interactionSource,
                    indication = indication,
                    onClickLabel = "Button action description",
                    role = Role.Button,
                    onClick = { showTooltip.value = true /*onClick*/ }
                )
            } else modifier
        }

        Box(
            modifier = _modifier
        ) {
            content()
        }
        Tooltip(showTooltip) {
//            // Tooltip content goes here.
            Text(
                text = "Licensed under the Apache License, Version 2.0 (the \"License\");",
                color = CrownTheme.colors.chipsTextSelect,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
        }
//    }
}

@Preview
@Composable
fun PreviewTooltipOnLongClickExample() {
    CrownTheme {
        TooltipOnLongClickExample(remember { mutableStateOf(false) })
    }
}