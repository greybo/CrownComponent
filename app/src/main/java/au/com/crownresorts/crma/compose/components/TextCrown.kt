package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun TextCrown(
    text: String? = "Title 1",
    style: TextStyle = MaterialTheme.typography.headlineMedium,
    modifier: Modifier.() -> Modifier = { this },
) {
    Text(
        text = text ?: "",
        modifier = modifier(Modifier.padding(8.dp)),
        style = style,
        color = CrownTheme.colors.textDefault
    )
}