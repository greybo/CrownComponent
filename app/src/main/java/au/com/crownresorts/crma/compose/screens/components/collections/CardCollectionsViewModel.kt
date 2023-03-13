package au.com.crownresorts.crma.compose.screens.components.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.components.ChipsToggleModel
import au.com.crownresorts.crma.compose.screens.components.collections.model.EntertainmentCell
import au.com.crownresorts.crma.compose.screens.components.collections.model.cellList

data class EntertainmentModel(
    val chipsList: List<ChipsToggleModel>,
    val cellList: List<EntertainmentCell>
)

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
        _state.value = _state.value?.copy(chipsList = list)
    }
}

val chipsList = listOf(
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
