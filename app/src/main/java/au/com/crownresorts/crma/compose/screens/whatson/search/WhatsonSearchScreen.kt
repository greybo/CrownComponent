package au.com.crownresorts.crma.compose.screens.whatson.search

import androidx.compose.runtime.Composable
import au.com.crownresorts.crma.compose.toolbar.ExpandableSearchView

@Composable
fun WhatsonSearchScreen() {
    ExpandableSearchView(
        searchDisplay = "",
        onSearchTextChanged = {},
        onSearchBack = {},
        expandedInitially = false
    )
}