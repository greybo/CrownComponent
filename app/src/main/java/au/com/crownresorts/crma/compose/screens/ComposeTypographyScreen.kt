package au.com.crownresorts.crma.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeTypographyScreen(navController: NavHostController = rememberNavController()) {

    val toolbarModel = toolbarModelDefault(
        titleText = "Typography",
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.ArrowBack -> navController.popBackStack()
            else -> TODO()
        }
    }

    Scaffold(topBar = {
        CrownToolbar(toolbarModel)
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState()),
        ) {


            Card(
                modifier = Modifier.padding(all = 8.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Text(
                    text = "Headline Large - Roboto 32/40 . 0",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Headline Medium - Roboto 28/36 . 0",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Headline Small - Roboto 24/32 . 0",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(all = 8.dp),
                )
            }


            Card(
                modifier = Modifier.padding(all = 8.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Text(
                    text = "Title Large - Roboto Medium 22/28 . 0 ",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Title Medium - Roboto Medium 16/24 . +0.15",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Title Small - Roboto Medium 14/20 . +0.1",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(all = 8.dp),
                )
            }


            Card(
                modifier = Modifier.padding(all = 8.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Text(
                    text = "Label Large - Roboto Medium 14/20 . +0.1",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Label Medium - Roboto Medium 12/16 . +0.5",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Label Small - Roboto Medium 11/16 . +0.5",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(all = 8.dp),
                )
            }


            Card(
                modifier = Modifier.padding(all = 8.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Text(
                    text = "Body Large - Roboto 16/24 . +0.5",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Body Medium - Roboto 14/20 . +0.25",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(all = 8.dp),
                )
                Text(
                    text = "Body Small - Roboto 12/16 . +0.4",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(all = 8.dp),
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewTypographyScreen() {
    ComposeTypographyScreen()
}