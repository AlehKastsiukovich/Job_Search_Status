package by.itacademy.training.jobsearchstatistic.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl

class CustomViewModelFactory(
    private val repository: VacanciesRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VacanciesViewModel::class.java)) {
            return VacanciesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
