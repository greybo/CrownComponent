package au.com.crownresorts.crma.compose.screens.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DetailsViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val hitId: Int get() = savedStateHandle.get<Int>("hitId") ?: -2

    val state = MutableLiveData<Int>()

    fun fetchData() {
        state.value = hitId
    }
}