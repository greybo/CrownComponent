package au.com.crownresorts.crma.compose.screens.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DetailsViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val hitId: String get() = savedStateHandle.get<String>("hitId") ?: "-2"

    val state = MutableLiveData<String>()

    init {
        fetchData()
    }

    fun fetchData() {
        state.value = hitId
    }
}