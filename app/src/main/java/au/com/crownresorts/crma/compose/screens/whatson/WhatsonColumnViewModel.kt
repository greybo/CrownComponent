package au.com.crownresorts.crma.compose.screens.whatson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.R
import au.com.crownresorts.crma.compose.db.HitModel
import au.com.crownresorts.crma.compose.db.fakeCellList
import au.com.crownresorts.crma.compose.router.RouterScreenType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class WhatsonColumnViewModel : ViewModel() {

    private var _property =  Properties.Melbourne
    var navController: NavHostController? = null

    private val _state = MutableLiveData<List<WhatsonSection>>()
    val state: LiveData<List<WhatsonSection>> = _state

    init {
        makeSection()
    }

    fun changeProperty(property: Properties) {
        if (_property != property) {
            _property = property
            makeSection()
        }
    }

    fun fetchData() {
        makeSection()
    }

    fun onClick(type: RouterWhatsonType) {
        val link = when (type) {
            is RouterWhatsonType.Details -> RouterScreenType.Details.name + "/${type.id}"
            is RouterWhatsonType.SeeAll -> RouterScreenType.SeeAll.name + "/${type.category}"
            is RouterWhatsonType.CategoryGroup -> RouterScreenType.SeeAll.name + "/${type.category}"
        }
        navController?.navigate(link)
    }

    private fun makeSection() {
        viewModelScope.launch(Dispatchers.Default) {
            val list = mutableListOf<WhatsonSection>()
            makeCategories()?.let {
                list.add(WhatsonSection.Categories(it.hashCode(), it))
            }
            makeLargeCell("Large")?.let {
                list.add(it)
            }
            makeSmallCell("Bars", "Restaurant", "SportBar")?.let {
                list.add(WhatsonSection.Divider())
                list.addAll(it)
            }
            makeSaveCell(2, 20, 19, 1)?.let {
                list.add(WhatsonSection.Divider())
                list.add(it)
            }
            _state.postValue(list)
        }
    }

    private fun makeLargeCell(name: String): WhatsonSection? {
        return fakeCellList
            .groupBy { it.category }
            .getOrDefault(name, null)
            ?.let {
                WhatsonSection.LargeCell(
                    category = "Large cell",
                    list = it,
                    seeAll = it.size > 4,
                )
            }
    }

    private fun makeSmallCell(vararg value: String): List<WhatsonSection>? {
        return fakeCellList.groupBy { it.category }.mapNotNull {
            if (value.contains(it.key)) {
                WhatsonSection.SmallCell(
                    category = it.key,
                    list = it.value,
                    seeAll = it.value.size > 4,
                )
            } else null
        }.filter { it.category.isNotEmpty() }
    }

    private fun makeSaveCell(vararg ids: Int): WhatsonSection? {
        val list = ids.map { id ->
            fakeCellList.find { it.hitId == id }
        }.filterNotNull()
//        val list = fakeCellList
//            .filter { hit ->
//                ids.find { (hit.id == it) } != null
//            }
        return WhatsonSection.SmallCell(
            category = "Saved",
            list = list,
            seeAll = list.size > 4
        )
    }

    private fun makeCategories(): List<CategoriesCell>? {
        return when (_property) {
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

    data class Categories(val _id: Int = Random.nextInt(), val list: List<CategoriesCell>) :
        WhatsonSection(_id)

    data class LargeCell(val category: String, val list: List<HitModel>, val seeAll: Boolean) :
        WhatsonSection(Random.nextInt())

    data class SmallCell(val category: String, val list: List<HitModel>, val seeAll: Boolean) :
        WhatsonSection(Random.nextInt())

    class Divider : WhatsonSection(Random.nextInt())
}

class CategoriesCell(val title: String, val iconRes: Int)


enum class Properties {
    Melbourne, Perth, Sydney
}