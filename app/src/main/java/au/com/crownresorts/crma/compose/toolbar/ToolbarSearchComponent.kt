package au.com.crownresorts.crma.compose.toolbar

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val heightAppBar = 56.dp

@Composable
fun ToolbarSearchComponent(
    searchDisplay: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchBack: () -> Unit,
    modifier: Modifier = Modifier,
    expandedInitially: Boolean = false,
) {
    val (expanded, onExpandedChanged) = remember {
        mutableStateOf(expandedInitially)
    }

    Crossfade(targetState = expanded) { isSearchFieldVisible ->
        when (isSearchFieldVisible) {
            true -> ExpandedSearchView(
                searchDisplay = searchDisplay,
                onSearchTextChanged = onSearchTextChanged,
                onSearchBack = onSearchBack,
                onExpandedChanged = onExpandedChanged,
                modifier = modifier,
            )

            false -> CollapsedSearchView(
                onExpandedChanged = onExpandedChanged,
                modifier = modifier,
            )
        }
    }
}

@Composable
fun CollapsedSearchView(
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(heightAppBar),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Tasks",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp)
        )
        IconButton(onClick = { onExpandedChanged(true) }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search icon",
                tint = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedSearchView(
    searchDisplay: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchBack: () -> Unit,
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current

    val textFieldFocusRequester = remember { FocusRequester() }

    SideEffect {
        textFieldFocusRequester.requestFocus()
    }

    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(searchDisplay, TextRange(searchDisplay.length)))
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(heightAppBar),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            onExpandedChanged(false)
            onSearchBack()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back icon",
                tint = Color.Black
            )
        }
        TextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onSearchTextChanged(it.text)
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "search icon",
                    tint = Color.Black,
                    modifier = Modifier.clickable {
                        onExpandedChanged(false)
                    }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(textFieldFocusRequester),
//            label = {
//                Text(text = "Search", color = tint)
//            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
    }
}

//@Composable
//fun SearchIcon(iconTint: Color) {
//    Icon(
//        imageVector = Icons.Filled.Search,
//        contentDescription = "search icon",
//        tint = iconTint
//    )
//}

@Preview
@Composable
fun CollapsedSearchViewPreview() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        ToolbarSearchComponent(
            searchDisplay = "",
            onSearchTextChanged = {},
            onSearchBack = {}
        )
    }
}

@Preview
@Composable
fun ExpandedSearchViewPreview() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        ToolbarSearchComponent(
            searchDisplay = "",
            onSearchTextChanged = {},
            expandedInitially = true,
            onSearchBack = {}
        )
    }
}