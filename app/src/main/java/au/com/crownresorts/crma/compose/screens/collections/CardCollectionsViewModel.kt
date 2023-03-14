package au.com.crownresorts.crma.compose.screens.collections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.*


class CardCollectionsViewModel : ViewModel() {

    private val chipsCurrent = fakeChipsList.toMutableList()
    private val _state = MutableLiveData(EntertainmentModel(fakeChipsList, cellList))
    val state: LiveData<EntertainmentModel> = _state

    init {
        makeItems()
    }

    private fun makeItems() {
        val selectedList = chipsCurrent.groupBy { it.select }[true]
        val foundList = findCell(selectedList)
        _state.value = _state.value?.copy(chipsList = chipsCurrent, cellList = foundList)
    }

    fun handleSelected(select: ChipsToggleModel) {
        val list = state.value?.chipsList?.toMutableList() ?: return
        val index = list.indexOf(select)
        val changed = select.copy(select = !select.select)
        if (index > -1) list[index] = changed
        chipsCurrent.clear()
        chipsCurrent.addAll(list)
        makeItems()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onClickReset() {
        chipsCurrent.replaceAll {
            it.select = false
            it
        }
        makeItems()
    }

    private fun findCell(selectedList: List<ChipsToggleModel>?): List<EntertainmentCell> {
        selectedList ?: return cellList
        return cellList.filter { cell ->
            selectedList.find { it.name == cell.body } != null
        }
    }
}

