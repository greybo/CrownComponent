package au.com.crownresorts.crma.compose.screens.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextBodyCrown(text: String? = "Body 1") {
    Text(
        text = text ?: "",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.bodyLarge
    )
}