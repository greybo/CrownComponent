package au.com.crownresorts.crma.compose.screens.collections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.*
import java.util.function.UnaryOperator


class CardCollectionsViewModel : ViewModel() {

    private val chipsCurrent = fakeChipsList.toMutableList()
    private val _state = MutableLiveData(EntertainmentModel(fakeChipsList, cellList))
    val state: LiveData<EntertainmentModel> = _state

    init {
        makeItems()
    }

    private fun makeItems() {
        val chipsList = chipsCurrent
        val foundList = findCell(chipsList)
        val model = _state.value
        _state.value = model?.copy(chipsList = chipsList, cellList = foundList)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun handleSelected(select: ChipsToggleModel) {
        chipsCurrent.replaceAll(ChipsOperator(select))
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

    private fun findCell(chipsList: List<ChipsToggleModel>?): List<EntertainmentCell> {
        chipsList ?: return cellList
        val selectedList = chipsList.groupBy { it.select }[true]
        val found = cellList.filter { cell ->
            selectedList?.find { cell.body.contains(it.name) } != null
        }
        return if (selectedList.isNullOrEmpty()) cellList else found
    }
}

@RequiresApi(Build.VERSION_CODES.N)
class ChipsOperator(private val onTapped: ChipsToggleModel) : UnaryOperator<ChipsToggleModel> {
    override fun apply(p0: ChipsToggleModel): ChipsToggleModel {
        return if (p0.name == onTapped.name) {
            p0.select = !p0.select
            p0
        } else p0
    }
}

