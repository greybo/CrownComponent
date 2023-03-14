package au.com.crownresorts.crma.compose.screens.components.collections.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.collections.model.ChipsToggleModel
import au.com.crownresorts.crma.compose.screens.components.collections.model.fakeChipsList
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun ItemChipsToggleHorizontal(
    listToggle: List<ChipsToggleModel>,
    edgeDp: Dp = 16.dp,
    callback: (ChipsToggleModel) -> Unit
) {
    LazyRow(
        modifier = Modifier.wrapContentHeight(),
        //Distance between items  in Horizontal
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        //Moves away from the right edge  in Horizontal
        contentPadding = PaddingValues(horizontal = edgeDp),
        content = {
            items(
                count = listToggle.size,
                key = { listToggle[it].name }
            ) {
                val item = listToggle[it]
                val bgColor =
                    if (item.select) CrownTheme.colors.chipsBgSelect else Color.Transparent
                val textColor =
                    if (item.select) CrownTheme.colors.chipsTextSelect else CrownTheme.colors.chipsBgSelect
                OutlinedButton(
                    onClick = { callback(item) },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = bgColor),
                    border = BorderStroke(1.dp, textColor),
                    modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(all = 2.dp),
                        color = textColor
                    )
                }
            }
        })
}

@Preview
@Composable
fun PreviewCollectionsButtonsHorizontal() {
    ItemChipsToggleHorizontal(listToggle = fakeChipsList, callback = {})
}


