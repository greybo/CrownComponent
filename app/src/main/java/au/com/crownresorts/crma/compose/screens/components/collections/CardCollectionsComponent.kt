package au.com.crownresorts.crma.compose.screens.components.collections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.components.ChipsToggleHorizontal
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun CardCollectionsComponent(viewModel: CardCollectionsViewModel = viewModel()) {

    val list = viewModel.state.observeAsState()
    val spanCount = 2
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Spacer(modifier = Modifier.height(24.dp))
        ChipsToggleHorizontal(list.value ?: emptyList(), viewModel::handleSelected)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "29 Results",
                color = CrownTheme.colors.textDefault
            )
            Text(
                text = "Reset",
                color = CrownTheme.colors.goldDefault
            )
        }
    }
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(spanCount),
//        state = rememberLazyGridState(),
//        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//    ) {
//        ChipsToggleHorizontal(list)
//    }
}

@Preview
@Composable
fun PreviewCardCollectionsComponent() {
    CrownTheme {
        CardCollectionsComponent()
    }
}