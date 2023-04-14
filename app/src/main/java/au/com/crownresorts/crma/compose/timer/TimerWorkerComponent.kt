package au.com.crownresorts.crma.compose.timer

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.*
import java.util.concurrent.TimeUnit

val constraints = Constraints.Builder()
    .setRequiresCharging(false)
    .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
    .build()

   // Note that the interval of 1 millisecond specified in the PeriodicWorkRequestBuilder
   // is not a practical interval for executing background tasks,
   // and should be changed to a more appropriate interval (e.g., every 10 minutes)
   // depending on the requirements of the app.
val myWork = PeriodicWorkRequestBuilder<MyWorker>(10, TimeUnit.MINUTES)
    .setConstraints(constraints)
    .build()

@Composable
fun TimerWorkerComponent() {
    val context = LocalContext.current

    WorkManager.getInstance(context).enqueueUniquePeriodicWork(
        "MyWorker",
        ExistingPeriodicWorkPolicy.REPLACE,
        myWork
    )
}

@Preview
@Composable
fun PreviewTimerWorkerComponent() {
    TimerWorkerComponent()
}

var countTimes: Int = 0

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        countTimes++
        Log.d("MyTimerWorker", "$countTimes minutes have passed")
        // add your code here to execute after every 10 minutes
        return Result.success()
    }
}
