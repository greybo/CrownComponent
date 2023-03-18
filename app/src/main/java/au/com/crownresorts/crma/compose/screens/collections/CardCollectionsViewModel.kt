package au.com.crownresorts.crma.compose.screens.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.ChipsToggleModel
import au.com.crownresorts.crma.compose.screens.collections.model.HitModel
import au.com.crownresorts.crma.compose.screens.collections.model.fakeCellList


class CardCollectionsViewModel : ViewModel() {

    private val chipsSelected = mutableSetOf<String>()
    private val _stateChips = MutableLiveData<List<ChipsToggleModel>>()
    val stateChips: LiveData<List<ChipsToggleModel>> = _stateChips

    private val cellCurrent: List<HitModel> get() = fakeCellList
    private val _stateCell = MutableLiveData<List<HitModel>>()
    val stateCell: LiveData<List<HitModel>> = _stateCell

    init {
        initData()
    }

    private fun initData() {
        makeChipsItems()
        setCellItems(fakeCellList)
    }

    private fun getCategories(): List<String> {
        return fakeCellList.groupBy { it.category }.map { it.key }
    }

    fun clickChips(category: String) {
        if (!chipsSelected.add(category)) {
            chipsSelected.remove(category)
        }
        makeChipsItems()
        makeCellItems()
    }

    private fun makeChipsItems(selectList: Set<String>? = chipsSelected) {
        val items = getCategories().map {
            ChipsToggleModel(
                name = it,
                select = (selectList?.contains(it) == true)
            )
        }
        setChipsItems(items)
    }

    private fun makeCellItems(
        chipsList: Set<String> = chipsSelected,
        cellList: List<HitModel> = cellCurrent,
    ) {
        val found = cellList.filter { cell ->
            chipsList.contains(cell.category)
        }
        setCellItems(if (chipsList.isEmpty()) cellList else found)
    }

    private fun setCellItems(cells: List<HitModel>?) {
        _stateCell.postValue(cells ?: emptyList())
    }

    private fun setChipsItems(chips: List<ChipsToggleModel>) {
        _stateChips.postValue(chips)
    }

    fun onClickReset() {
        chipsSelected.clear()
        initData()
    }
}
