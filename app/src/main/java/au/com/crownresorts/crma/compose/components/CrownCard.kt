package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun CardCrown(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {

    Card(
        modifier = modifier.padding(all = 8.dp).fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CrownTheme.colors.cardBg),
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.cardElevation(4.dp),
        content = content
    )
}