package au.com.crownresorts.crma.compose.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun DetailsSectionAdapter(
    navController: NavHostController,
    viewModel: DetailsViewModel = viewModel()
) {
    val state = viewModel.state.observeAsState()

    Text(
        text = state.value.toString(),
        fontSize = 25.sp
    )
}