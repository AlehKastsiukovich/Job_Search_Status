package by.itacademy.training.jobsearchstatistic.app

import android.app.Application
import by.itacademy.training.jobsearchstatistic.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }
}
