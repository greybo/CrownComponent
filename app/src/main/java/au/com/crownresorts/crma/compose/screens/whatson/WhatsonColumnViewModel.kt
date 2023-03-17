package au.com.crownresorts.crma.compose.screens.whatson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.HitModel
import au.com.crownresorts.crma.compose.screens.collections.model.fakeCellList
import com.example.crownexample.R
import kotlin.random.Random

class WhatsonColumnViewModel : ViewModel() {

    private var _properties = Properties.Melbourne

    private val _state = MutableLiveData<List<WhatsonSection>>()
    val state: LiveData<List<WhatsonSection>> = _state

    init {
        makeSection()
    }

    fun fetchData(properties: Properties = _properties) {
        if (_properties != properties) {
            _properties = properties
            makeSection()
        }
    }

    fun onClickCategory(category: String) {

    }

    private fun makeSection() {
        val list = mutableListOf<WhatsonSection>()
        makeCategories()?.let {
            list.add(WhatsonSection.Categories(it.hashCode(), it))
        }
        makeLargeCell()?.let {
            list.addAll(it)
        }
        _state.value = list
    }

    private fun makeLargeCell(): List<WhatsonSection>? {
        return fakeCellList.groupBy { it.category }.map {
            WhatsonSection.LargeCell(
                category = it.key,
                list = it.value,
                seeAll = it.value.size > 4,
            )
        }
    }

    private fun makeCategories(): List<CategoriesCell>? {
        return when (_properties) {
            Properties.Melbourne -> listOf(
                CategoriesCell("Category1", R.drawable.ic_dining_transparent),
                CategoriesCell("Category2", R.drawable.ic_dining_transparent),
                CategoriesCell("Category3", R.drawable.ic_dining_transparent),
            )
            Properties.Perth -> listOf(
                CategoriesCell("Category1", R.drawable.ic_dining_transparent),
                CategoriesCell("Category2", R.drawable.ic_dining_transparent),
                CategoriesCell("Category3", R.drawable.ic_dining_transparent),
                CategoriesCell("Category4", R.drawable.ic_dining_transparent),
            )
            Properties.Sydney -> listOf(
                CategoriesCell("Category1", R.drawable.ic_dining_transparent),
                CategoriesCell("Category2", R.drawable.ic_dining_transparent),
                CategoriesCell("Category3", R.drawable.ic_dining_transparent),
                CategoriesCell("Category4", R.drawable.ic_dining_transparent),
                CategoriesCell("Category5", R.drawable.ic_dining_transparent),
            )
        }

    }
}

sealed class WhatsonSection(val id: Any) {

    data class Categories(val _id: Int = Random.nextInt(), val list: List<CategoriesCell>) : WhatsonSection(_id)
    data class LargeCell(val category: String, val list: List<HitModel>, val seeAll: Boolean) : WhatsonSection(category)
}

class CategoriesCell(val title: String, val iconRes: Int)


enum class Properties {
    Melbourne, Perth, Sydney
}