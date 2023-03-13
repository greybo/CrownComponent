package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun TextBodyCrown(text: String? = "Body 1", modifier: Modifier? = null) {
    val _modifier = modifier ?: Modifier.padding(16.dp)
    Text(
        text = text ?: "",
        modifier = _modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = CrownTheme.colors.textDefault
    )
}