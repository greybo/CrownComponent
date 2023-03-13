package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun TextHeadlineCrown(text: String? = "Title 1",modifier: Modifier = Modifier) {
    Text(
        text = text ?: "",
        modifier = modifier.padding(8.dp),
        style = MaterialTheme.typography.headlineMedium,
        color = CrownTheme.colors.textDefault
    )
}