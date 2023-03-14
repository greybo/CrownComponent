package au.com.crownresorts.crma.compose.screens.components.collections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.components.collections.items.ItemChipsToggleHorizontal
import au.com.crownresorts.crma.compose.screens.components.collections.items.ItemEntertainmentCell
import au.com.crownresorts.crma.compose.screens.components.collections.items.ItemResultButtons
import au.com.crownresorts.crma.compose.theme.CrownTheme

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CardCollectionsComponent(viewModel: CardCollectionsViewModel = viewModel()) {

    val state = viewModel.state.observeAsState()
    val edgeDp = 16.dp
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        ItemChipsToggleHorizontal(
            listToggle = state.value?.chipsList ?: emptyList(),
            edgeDp = edgeDp,
            callback = viewModel::handleSelected
        )
        Spacer(modifier = Modifier.height(16.dp))
        ItemResultButtons(
            countFound = state.value?.cellList?.size ?: 0,
            edgeDp = edgeDp,
            onClickReset = viewModel::onClickReset
        )
        Spacer(modifier = Modifier.height(16.dp))
        ItemEntertainmentCell(state.value?.cellList ?: emptyList(), edgeDp)
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