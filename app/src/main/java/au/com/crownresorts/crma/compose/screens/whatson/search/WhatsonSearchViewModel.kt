package au.com.crownresorts.crma.compose.screens.whatson.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.screens.whatson.main.CategoriesCell
import au.com.crownresorts.crma.compose.screens.whatson.main.WhatsonSection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WhatsonSearchViewModel : ViewModel() {

    private val _state = MutableLiveData<List<WhatsonSection>>()
    fun state(): LiveData<List<WhatsonSection>> {
        fetchData()
        return _state
    }


    fun fetchData() {
        viewModelScope.launch(Dispatchers.Default) {
            _state.postValue(listOf(makeCategories()))
        }
    }


    private fun makeCategories(): WhatsonSection {
        return WhatsonSection.SearchCategories(list = list, categoryName = "Categories", false)
    }


}

val list = listOf(
    CategoriesCell("Category1", R.drawable.ic_dining_transparent),
    CategoriesCell("Category2", R.drawable.ic_dining_transparent),
    CategoriesCell("Category3", R.drawable.ic_dining_transparent),
    CategoriesCell("Category4", R.drawable.ic_dining_transparent),
    CategoriesCell("Category5", R.drawable.ic_dining_transparent),
    CategoriesCell("Category6", R.drawable.ic_dining_transparent),
    CategoriesCell("Category7", R.drawable.ic_dining_transparent),
    CategoriesCell("Category8", R.drawable.ic_dining_transparent),
    CategoriesCell("Category9", R.drawable.ic_dining_transparent),
)