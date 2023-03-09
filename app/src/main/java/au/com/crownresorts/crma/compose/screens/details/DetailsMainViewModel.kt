package au.com.crownresorts.crma.compose.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import au.com.crownresorts.crma.compose.router.RouterScreenType

class DetailsMainViewModel : ViewModel() {

    var router: NavHostController? = null
    private val _state = MutableLiveData<List<MainComposeItems>>()
    val state: LiveData<List<MainComposeItems>> = _state

    init {
        _state.value = MainComposeItems.values().toList()
    }

    fun handleOnClickItem(item: MainComposeItems) {
        when (item) {
            MainComposeItems.Color ->  router?.navigate(RouterScreenType.Color.name)
            else -> TODO()
        }
    }
}

enum class MainComposeItems(val rawValue: String) {
    Color("Color"),
    Typography("Typography"),
    Components("Components"),
    Templates("Templates"),

}