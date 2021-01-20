package by.itacademy.training.jobsearchstatistic.view.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl

class CustomViewModelFactory(
    private val context: Context,
    private val dao: VacanciesDao,
    private val mapper: DtoMapperImpl,
    private val repository: VacanciesRepositoryImpl
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VacanciesViewModel::class.java)) {
            return VacanciesViewModel(context, dao, mapper, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}