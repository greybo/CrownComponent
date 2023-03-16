package au.com.crownresorts.crma.compose.screens.whatson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.com.crownresorts.crma.compose.screens.components.TabLayoutComponent
import au.com.crownresorts.crma.compose.toolbar.CrownToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsonScreen() {
    Scaffold(topBar = { CrownToolbar() }) {
        Column(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            TabLayoutComponent()
        }
    }
}

@Preview
@Composable
fun PreviewWhatsonScreen() {
    WhatsonScreen()
}