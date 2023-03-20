package au.com.crownresorts.crma.compose.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp

@Composable
fun DetailsSectionAdapter(
    viewModel: DetailsViewModel
) {
    val state = viewModel.state.observeAsState()

    Text(
        text = state.value.toString(),
        fontSize = 25.sp
    )
}