package au.com.crownresorts.crma.compose.screens.collections.items

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ItemResultButtons(
    countFound: Int,
    edgeDp: Dp = 16.dp,
    onClickReset: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = edgeDp, end = edgeDp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$countFound Results",
            color = CrownTheme.colors.textDefault,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = "Reset",
            color = CrownTheme.colors.goldDefault,
            modifier = Modifier.clickable { onClickReset() },
            style = MaterialTheme.typography.labelLarge
        )
    }
}