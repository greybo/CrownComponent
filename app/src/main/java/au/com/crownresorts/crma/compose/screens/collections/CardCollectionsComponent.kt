package au.com.crownresorts.crma.compose.screens.collections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.collections.items.ItemChipsToggleHorizontal
import au.com.crownresorts.crma.compose.screens.collections.items.ItemEntertainmentCell
import au.com.crownresorts.crma.compose.screens.collections.items.ItemResultButtons
import au.com.crownresorts.crma.compose.theme.CrownTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardCollectionsComponent(viewModel: CardCollectionsViewModel = viewModel()) {

    val stateCell = viewModel.stateCell.observeAsState()
    val stateChips = viewModel.stateChips.observeAsState()
    val edgeDp = 16.dp
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        ItemChipsToggleHorizontal(
            listToggle = stateChips.value ?: emptyList(),
            edgeDp = edgeDp,
            callback = viewModel::clickChips
        )
        Spacer(modifier = Modifier.height(16.dp))
        ItemResultButtons(
            countFound = stateChips.value?.size ?: 0,
            edgeDp = edgeDp,
            onClickReset = viewModel::onClickReset
        )
        Spacer(modifier = Modifier.height(24.dp))
        ItemEntertainmentCell(stateCell.value ?: emptyList(), edgeDp)
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun PreviewCardCollectionsComponent() {
    CrownTheme {
        CardCollectionsComponent()
    }
}