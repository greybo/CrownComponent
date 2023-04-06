package au.com.crownresorts.crma.compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun HorizontalTitle(title: String = "Rewards Title", callback: (() -> Unit)? = null) {

    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .clickable { callback?.invoke() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.dining_new),
            contentDescription = "icon",
            tint = CrownTheme.colors.iconTint,
        )
        TextHeadlineCrown(title)

//        Text(
//            text = title,
//            style = MaterialTheme.typography.headlineMedium,
//            modifier = Modifier.padding(start = 8.dp),
//        )
    }
}

@Preview
@Composable
fun PreviewHorizontalTitle() {
    HorizontalTitle()
}