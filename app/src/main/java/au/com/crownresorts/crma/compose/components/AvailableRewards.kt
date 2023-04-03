package au.com.crownresorts.crma.compose.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun AvailableRewards(text: String = "Multi-Level & P4 \nParking") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .aspectRatio(5f / 1f)
            .background(color = CrownTheme.colors.goldDefault)
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.weight(1f)) {
            TextWithIcon(text = text)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Expires 12:00am",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                color = CrownTheme.colors.textHigh,
                textAlign = TextAlign.End,
            )
            Text(
                text = "07/10/19",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End,
                color = CrownTheme.colors.textHigh
            )
        }
    }
}

@Preview
@Composable
fun PreviewAvailableRewards() {
    CrownTheme {
        AvailableRewards()
    }
}