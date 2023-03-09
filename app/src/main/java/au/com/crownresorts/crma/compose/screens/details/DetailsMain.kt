package au.com.crownresorts.crma.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.crownresorts.crma.compose.screens.details.DetailsMainViewModel
import au.com.crownresorts.crma.compose.screens.details.adapter.MainComposeAdapter
import au.com.crownresorts.crma.compose.theme.CrownTheme

@Composable
fun ComposeDetailsMain(viewModel: DetailsMainViewModel = viewModel()) {
    val list = viewModel.state.observeAsState()
    CrownTheme(isDark = false) {

        Box(modifier = Modifier.fillMaxSize()) {
            MainComposeAdapter(list.value ?: emptyList())
        }
    }
}