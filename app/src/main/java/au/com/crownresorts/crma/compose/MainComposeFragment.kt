package au.com.crownresorts.crma.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import au.com.crownresorts.crma.compose.router.RouterCompose
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar


class MainComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CrownTheme(isDark = true) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CrownToolbar()
                        RouterCompose()
                    }
                }
            }
        }
    }

}