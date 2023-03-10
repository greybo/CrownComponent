package au.com.crownresorts.crma.compose.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.crownresorts.crma.compose.theme.CrownTheme
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
            .background(CrownTheme.colors.background)
            .verticalScroll(rememberScrollState())
    ) {
        CrownToolbar(toolbarModel)

        CardCrown {
            HorizontalTitle()
        }

//        val dark = crownColors(true).divider
//        val light = crownColors(false).divider
        CardCrown {
            TextBodyCrown("Divider", Modifier.padding(16.dp))
            RowCrown {
                DividerComponent(Modifier.background(CrownTheme.colors.divider))
            }
//            RowCrown {
//                DividerComponent(Modifier.background(light))
//            }
        }

        CardCrown {
            TextHeadlineCrown("Title 1")
            TextBodyCrown(
                "Nam in lacus vulputate, dignissim dui eget, tempus est. Curabitur ac velit rutrum, viverra arcu ut, mollis odio. Proin a ligula quam. Quisque bibendum finibus metus eu ornare. Nulla consequat ex sed sem varius, in gravida orci cursus. Quisque congue sit amet odio vel pellentesque. Morbi tempor euismod justo id volutpat.",
                Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewComponentScreen() {
    ComposeComponentScreen()
}