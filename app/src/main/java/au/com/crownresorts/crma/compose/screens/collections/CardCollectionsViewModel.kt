package au.com.crownresorts.crma.compose.screens.collections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.crownresorts.crma.compose.screens.collections.model.*
import java.util.function.UnaryOperator


@RequiresApi(Build.VERSION_CODES.N)
class CardCollectionsViewModel : ViewModel() {

    private val chipsCurrent = fakeChipsList.toMutableList()
    private val _state = MutableLiveData(EntertainmentModel(fakeChipsList, cellList))
    val state: LiveData<EntertainmentModel> = _state

    init {
        makeItems()
    }

    private fun makeItems() {
        val chipsList: List<ChipsToggleModel> = chipsCurrent
        val foundList = findCell(chipsList)
        _state.value = EntertainmentModel(chipsList = chipsList, cellList = foundList)
    }

    fun handleSelected(select: ChipsToggleModel) {
        chipsCurrent.replaceAll(ChipsOperator(select.name))
        makeItems()
    }

    fun onClickReset() {
        chipsCurrent.replaceAll {
            it.default()
        }
        makeItems()
    }

    private fun findCell(chipsList: List<ChipsToggleModel>?): List<EntertainmentCell> {
        val selectedList = chipsList?.groupBy { it.select }?.getOrDefault(true, emptyList())
        val found = cellList.filter { cell ->
            selectedList?.find { cell.body.contains(it.name) } != null
        }
        return if (selectedList.isNullOrEmpty()) cellList else found
    }
}

@RequiresApi(Build.VERSION_CODES.N)
class ChipsOperator(private val name: String) : UnaryOperator<ChipsToggleModel> {
    override fun apply(p0: ChipsToggleModel): ChipsToggleModel {
        return if (p0.name == name) {
            p0.revertSelect()
        } else p0
    }
}

