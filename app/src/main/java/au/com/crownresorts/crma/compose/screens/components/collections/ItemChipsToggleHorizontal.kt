package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.screens.components.collections.model.ChipsToggleModel
import au.com.crownresorts.crma.compose.screens.components.collections.model.fakeChipsList
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun ItemChipsToggleHorizontal(
    listNames: List<ChipsToggleModel>,
    callback: (ChipsToggleModel) -> Unit
) {
    Row {
        LazyHorizontalGrid(
            //set count of rows
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .height(48.dp),
            //Distance between items
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            //Moves away from the right edge
            contentPadding = PaddingValues(horizontal = 16.dp),
            content = {
                items(
                    count = listNames.size,
                    key = { listNames[it].name }
                ) {
                    val item = listNames[it]
                    val bgColor =
                        if (item.select) CrownTheme.colors.chipsBgSelect else Color.Transparent
                    val textColor =
                        if (item.select) CrownTheme.colors.chipsTextSelect else CrownTheme.colors.chipsBgSelect
                    OutlinedButton(
                        onClick = { callback(item) },
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = bgColor),
                        border = BorderStroke(1.dp, textColor)
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

}

@Preview
@Composable
fun PreviewCollectionsButtonsHorizontal() {
    ItemChipsToggleHorizontal(listNames = fakeChipsList, {})
}


