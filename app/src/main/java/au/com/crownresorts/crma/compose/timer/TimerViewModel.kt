package au.com.crownresorts.crma.compose.timer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class TimerViewModel : ViewModel() {

    private var job: Deferred<Unit>? = null
    private var countTimes = 0
    private val state = MutableLiveData(0)

    fun runTimer(millis: Long): LiveData<Int> {
        if (job == null) {
            job = CoroutineScope(Dispatchers.IO).launchPeriodicAsync(millis) {
                countTimes++
                state.postValue(countTimes)
                Log.d("MyTimer", "$countTimes times have passed")
            }
        }
        return state
    }

    private fun CoroutineScope.launchPeriodicAsync(
        repeatMillis: Long,
        action: () -> Unit
    ) = async {
        if (repeatMillis > 0) {
            while (isActive) {
                action()
                delay(repeatMillis)
            }
        } else {
            action()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
        job = null
    }
}