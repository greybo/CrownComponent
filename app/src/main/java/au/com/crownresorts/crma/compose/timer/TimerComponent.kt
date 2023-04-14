package au.com.crownresorts.crma.compose.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun TimerComponent(viewModel: TimerViewModel = viewModel()) {

    val state = viewModel.runTimer(2000)
    val count = state.observeAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "count: ${count.value}",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTimerComponent() {
    TimerComponent()
}