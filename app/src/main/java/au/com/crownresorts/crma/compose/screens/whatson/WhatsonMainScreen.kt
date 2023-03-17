package au.com.crownresorts.crma.compose.screens.whatson

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.com.crownresorts.crma.compose.screens.components.TabLayoutComponent
import au.com.crownresorts.crma.compose.theme.CrownTheme
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsonMainScreen() {

    val propertyCurrent = remember {
        mutableStateOf(Properties.Melbourne)
    }
    Scaffold(
        topBar = { CrownToolbar() }) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(color = CrownTheme.colors.background)
        ) {
            TabLayoutComponent(propertyCurrent)
            WhatsonSectionAdapter(propertyCurrent)
        }
    }
}

@Preview
@Composable
fun PreviewWhatsonScreen() {
    WhatsonMainScreen()
}