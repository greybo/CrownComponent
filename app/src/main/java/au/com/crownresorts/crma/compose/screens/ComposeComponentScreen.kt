package au.com.crownresorts.crma.compose.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.theme.crownColors
import au.com.crownresorts.crma.compose.toolbar.ActionButtonType
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar
import au.com.crownresorts.crma.compose.toolbar.toolbarModelDefault

@Composable
fun ComposeComponentScreen(navController: NavHostController = rememberNavController()) {

    val toolbarModel = toolbarModelDefault(
        titleText = "Component",
        rightIcon = null
    ) {
        when (it) {
            ActionButtonType.ArrowBack -> navController.popBackStack()
            else -> TODO()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        CrownToolbar(toolbarModel)
        CardRowCrown {
            HorizontalTitle()
        }

        val dark = crownColors(true).divider
        val light = crownColors(false).divider
        CardRowCrown {
            Text(
                text = "Divider",
                modifier = Modifier.padding(16.dp)
            )
            RowCrown {
                DividerComponent(Modifier.background(dark))
            }
            RowCrown(/*Modifier.background(Color.Black)*/) {
                DividerComponent(Modifier.background(light))
            }
        }


    }
}

@Preview
@Composable
fun PreviewComponentScreen() {
    ComposeComponentScreen()
}