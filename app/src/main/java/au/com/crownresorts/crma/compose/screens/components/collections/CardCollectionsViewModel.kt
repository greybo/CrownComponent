package au.com.crownresorts.crma.compose.screens.components.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.components.collections.model.*


class CardCollectionsViewModel : ViewModel() {
    private val _state = MutableLiveData(EntertainmentModel(chipsList, cellList))
    val state: LiveData<EntertainmentModel> = _state
//    private val listSelected = mutableListOf<ChipsToggleModel>()

    fun handleSelected(select: ChipsToggleModel) {
        val list = state.value?.chipsList?.toMutableList() ?: return
        val index = list.indexOf(select)
        if (index == -1) return
        val changed = select.copy(select = !select.select)
        list[index] = changed
        val selectedList = list.groupBy { it.select }[true]
        val foundList = findCell(selectedList)
        _state.value = _state.value?.copy(chipsList = list, cellList = foundList)
    }

    private fun findCell(selectedList: List<ChipsToggleModel>?): List<EntertainmentCell> {
        selectedList ?: return cellList
        return cellList.filter { cell ->
            selectedList.find { it.name == cell.body } != null
        }
    }
}

