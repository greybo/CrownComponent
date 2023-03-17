package au.com.crownresorts.crma.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.com.crownresorts.crma.compose.router.RouterCompose
import au.com.crownresorts.crma.compose.theme.CrownTheme

class ComposeExampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
    @Composable
    private fun Greeting() {
        CrownTheme(/*isDark = false*/) {
            Box(modifier = Modifier.fillMaxSize().background(color= CrownTheme.colors.background)) {
                RouterCompose()
            }
        }
    }
    @Preview
    @Composable
    fun PreviewRouterCompose() {
        Greeting()
    }
}