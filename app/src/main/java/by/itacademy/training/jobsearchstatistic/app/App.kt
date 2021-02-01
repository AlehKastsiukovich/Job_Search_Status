package by.itacademy.training.jobsearchstatistic.app

import android.app.Application
import by.itacademy.training.jobsearchstatistic.di.appModule
import by.itacademy.training.jobsearchstatistic.di.fragmentModule
import by.itacademy.training.jobsearchstatistic.di.repositoryModule
import by.itacademy.training.jobsearchstatistic.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule, repositoryModule, fragmentModule))
        }
    }
}
