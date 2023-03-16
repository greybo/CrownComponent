package au.com.crownresorts.crma.compose.screens.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.ChipsToggleModel
import au.com.crownresorts.crma.compose.screens.collections.model.EntertainmentCell
import au.com.crownresorts.crma.compose.screens.collections.model.fakeCellList
import au.com.crownresorts.crma.compose.screens.collections.model.fakeChipsList


class CardCollectionsViewModel : ViewModel() {

    private val chipsCurrent get() = stateChips.value?.toMutableList() ?: emptyList()
    private val _stateChips = MutableLiveData<List<ChipsToggleModel>>()
    val stateChips: LiveData<List<ChipsToggleModel>> = _stateChips

    private val _stateCell = MutableLiveData<List<EntertainmentCell>>()
    val stateCell: LiveData<List<EntertainmentCell>> = _stateCell

    init {
        initData()
    }

    private fun initData() {
        makeChipsItems(fakeChipsList)
        setCellItems(fakeCellList)
    }

    fun clickChips(
        name: String,
        chips: List<ChipsToggleModel> = chipsCurrent,
    ) {
        val _chips = chips.map { item ->
            if (item.name == name) {
                item.revertSelect()
            } else item
        }
        makeChipsItems(_chips)
        makeCellItems(_chips)
    }


    private fun makeCellItems(
        chipsList: List<ChipsToggleModel>?,
        cellList: List<EntertainmentCell> = fakeCellList,
    ) {
        val selectedList = chipsList?.groupBy { it.select }?.getOrElse(true) { emptyList() }
        val found = cellList.filter { cell ->
            selectedList?.find { cell.body.contains(it.name) } != null
        }
        setCellItems(if (selectedList.isNullOrEmpty()) cellList else found)
    }

    private fun setCellItems(cells: List<EntertainmentCell>?) {
        _stateCell.postValue(cells ?: emptyList())
    }

    private fun makeChipsItems(chips: List<ChipsToggleModel>) {
        _stateChips.postValue(chips)
    }

    fun onClickReset() {
        initData()
    }
}
