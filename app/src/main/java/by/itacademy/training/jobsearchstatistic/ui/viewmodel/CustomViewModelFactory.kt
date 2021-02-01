package by.itacademy.training.jobsearchstatistic.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl

class CustomViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private var model: VacanciesViewModel? = null

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VacanciesViewModel::class.java)) {
            val database = VacanciesDatabase.getDatabase(context.applicationContext)
            val repository = VacanciesRepositoryImpl(database.vacanciesDao(), DtoMapperImpl())
            return if (model == null) {
                model = VacanciesViewModel(repository)
                model as T
            } else {
                model as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
