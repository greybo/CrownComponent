package au.com.crownresorts.crma.compose.screens.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.White

@Composable
fun RowCrown(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
fun CardRowCrown(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {

    Card(
        modifier = modifier.padding(all = 8.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.cardElevation(4.dp),
        content = content
    )
}