package au.com.crownresorts.crma.compose.screens.tooltip

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.DarkGrey
import kotlinx.coroutines.delay

private val TooltipOffset = DpOffset(0.dp, 16.dp)

// Tooltip open/close animation duration.
private const val InTransitionDuration = 64
private const val OutTransitionDuration = 240

// Default timeout before tooltip close
private const val TooltipTimeout = 2_000L - OutTransitionDuration

@Composable
fun Tooltip(
    expanded: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    timeoutMillis: Long = TooltipTimeout,
    offset: DpOffset = TooltipOffset,
    backgroundColor: Color = DarkGrey,
    content: @Composable ColumnScope.() -> Unit,
) {
    val expandedStates = remember { MutableTransitionState(false) }
    expandedStates.targetState = expanded.value

    if (expandedStates.currentState || expandedStates.targetState) {
        if (expandedStates.isIdle) {
            LaunchedEffect(timeoutMillis, expanded) {
                delay(timeoutMillis)
                expanded.value = false
            }
        }
        TooltipContent(expandedStates, offset, backgroundColor, modifier, content)
    }
}

@Composable
private fun TooltipContent(
    expandedStates: MutableTransitionState<Boolean>,
    offset: DpOffset,
    backgroundColor: Color,
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    // Tooltip open/close animation.
    val transition = updateTransition(expandedStates, "Tooltip")

    val alpha by transition.animateFloat(
        label = "alpha",
        transitionSpec = {
            if (false isTransitioningTo true) {
                // Dismissed to expanded
                tween(durationMillis = InTransitionDuration)
            } else {
                // Expanded to dismissed.
                tween(durationMillis = OutTransitionDuration)
            }
        }
    ) {
        if (it) 1f else 0f
    }

    DropdownMenu(
        offset = offset,
        modifier = modifier
            .alpha(alpha)
            .background(
                color = backgroundColor/*MaterialTheme.colorScheme
                .contentColorFor(backgroundColor)
                .takeOrElse { backgroundColor.onColor() }*/
            ),
        expanded = true,
        onDismissRequest = { /*todo*/ },
        content = content
    )
}