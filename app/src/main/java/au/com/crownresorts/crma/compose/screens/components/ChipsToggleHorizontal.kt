package au.com.crownresorts.crma.compose.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import au.com.crownresorts.crma.compose.screens.components.collections.listTemp
import au.com.crownresorts.crma.compose.theme.CrownTheme


@Composable
fun ChipsToggleHorizontal(listNames: List<ChipsToggleModel> = listTemp, callback: (ChipsToggleModel) -> Unit) {
    Row {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .height(64.dp)
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                items(
                    count = listNames.size,
                    key = { listNames[it].name }
                ) {
                    val item = listNames[it]
                    val bgColor = if (item.select) CrownTheme.colors.chipsBgSelect else Color.Transparent
                    val textColor = if (item.select) CrownTheme.colors.chipsTextSelect else CrownTheme.colors.chipsBgSelect
                    OutlinedButton(
                        onClick = { callback(item) },
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = bgColor),
                        border = BorderStroke(1.dp,textColor)
                    ) {
                        Text(
                            text = item.name, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(all = 2.dp),
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
    ChipsToggleHorizontal(listNames = listTemp, {})
}


data class ChipsToggleModel(val name: String, val select: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChipsToggleModel

        if (name != other.name) return false
        if (select != other.select) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + select.hashCode()
        return result
    }
}