package au.com.crownresorts.crma.compose.toolbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.crownresorts.crma.compose.theme.CrownTheme

val heightAppBar = 56.dp

@Composable
fun ToolbarSearchComponent(
    searchDisplay: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchBack: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Surface(
        shape = RectangleShape,
        shadowElevation = 2.dp,
        color = CrownTheme.colors.appBar.background
    ) {
        ExpandedSearchView(
            searchDisplay = searchDisplay,
            onSearchTextChanged = onSearchTextChanged,
            onSearchBack = onSearchBack,
            modifier = modifier,
        )
//        Crossfade(targetState = expanded) { isSearchFieldVisible ->
//            when (isSearchFieldVisible) {
//                true -> ExpandedSearchView(
//                    searchDisplay = searchDisplay,
//                    onSearchTextChanged = onSearchTextChanged,
//                    onSearchBack = onSearchBack,
//                    onExpandedChanged = onExpandedChanged,
//                    modifier = modifier,
//                )
//
//                false -> CollapsedSearchView(
//                    onExpandedChanged = onExpandedChanged,
//                    modifier = modifier,
//                )
//            }
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedSearchView(
    searchDisplay: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchBack: () -> Unit,
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

    fun onClear() {
        textFieldValue = TextFieldValue("", TextRange(0))
        onSearchTextChanged("")
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(heightAppBar),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            if (textFieldValue.text.isNotEmpty()) {
                onClear()
            } else
                onSearchBack()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back icon",
                tint = CrownTheme.colors.appBar.tint
            )
        }
        TextField(
            textStyle = MaterialTheme.typography.bodyLarge ,
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onSearchTextChanged(it.text)
            },
            trailingIcon = {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Mic,
                        contentDescription = "search icon",
                        tint = CrownTheme.colors.appBar.tint,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                    if (textFieldValue.text.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "search icon",
                            tint = CrownTheme.colors.appBar.tint,
                            modifier = Modifier
                                .padding(start = 8.dp, end = 16.dp)
                                .clickable {
                                    onClear()
                                }
                        )
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = CrownTheme.colors.textDefault,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent//CrownTheme.colors.background
            ),
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

@Preview
@Composable
fun ExpandedSearchViewPreview() {

    ToolbarSearchComponent(
        searchDisplay = "test",
        onSearchTextChanged = {},
        onSearchBack = {}
    )

}