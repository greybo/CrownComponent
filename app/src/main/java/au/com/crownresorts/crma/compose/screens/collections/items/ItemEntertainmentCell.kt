package au.com.crownresorts.crma.compose.screens.collections.items

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.collections.model.HitModel
import au.com.crownresorts.crma.compose.screens.components.GradientBoxFull
import au.com.crownresorts.crma.compose.screens.components.GradientHalf
import au.com.crownresorts.crma.compose.theme.CrownTheme
import coil.compose.AsyncImage

@Composable
fun ItemEntertainmentCell(item: HitModel, modifier: Modifier) {

    val context = LocalContext.current
    val localDensity = context.resources.displayMetrics.density
    val columnHeightDp = remember { mutableStateOf(0.dp) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .onGloballyPositioned { coordinates ->
                columnHeightDp.value = (coordinates.size.height / localDensity).dp
            },
        contentAlignment = Alignment.BottomStart,
    ) {
        GradientBoxFull(maxHeight, maxWidth)
        AsyncImage(
            model = item.urlImage,
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
        GradientHalf(maxHeight, maxWidth)
        Column(modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                color = CrownTheme.colors.entertainmentCellText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = item.body,
                style = MaterialTheme.typography.bodySmall,
                color = CrownTheme.colors.entertainmentCellText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
