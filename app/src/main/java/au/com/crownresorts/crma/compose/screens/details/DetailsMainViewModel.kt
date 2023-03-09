package au.com.crownresorts.crma.compose.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsMainViewModel : ViewModel() {

    private val _state = MutableLiveData<List<MainComposeItems>>()
    val state: LiveData<List<MainComposeItems>> = _state

    init {
        _state.value = MainComposeItems.values().toList()
    }

}

enum class MainComposeItems(val rawValue: String) {
    Color("Color"),
    Typography("Typography"),
    Components("Components"),
    Templates("Templates"),

}