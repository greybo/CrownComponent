package au.com.crownresorts.crma.compose.screens.components.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.components.ChipsToggleModel

class CardCollectionsViewModel : ViewModel() {
    private val _state = MutableLiveData(listTemp)
    val state: LiveData<List<ChipsToggleModel>> = _state
    private val listSelected = mutableListOf<ChipsToggleModel>()

    fun handleSelected(select: ChipsToggleModel) {
        val list = state.value?.toMutableList() ?: return
        val index = list.indexOf(select)
        if (index == -1) return
        val changed = select.copy(select = !select.select)
        list[index] = changed
        _state.value = list
    }
//    fun handleSelected(select: ChipsToggleModel): List<ChipsToggleModel> {
//        val list = listSelected.value.toMutableList()
//        if (list.find { it.name == select.name } != null) {
//            list.remove(select)
//        } else list.add(select)
//        listSelected.value = list
//        return list
//    }
}

val listTemp = listOf(
    ChipsToggleModel("one"),
    ChipsToggleModel("two"),
    ChipsToggleModel("three"),
    ChipsToggleModel("four"),
    ChipsToggleModel("five"),
    ChipsToggleModel("six"),
    ChipsToggleModel("seven"),
    ChipsToggleModel("eight"),
    ChipsToggleModel("nine"),
    ChipsToggleModel("ten"),
    ChipsToggleModel("eleven"),
    ChipsToggleModel("twelve"),
    ChipsToggleModel("thirteen")
)
