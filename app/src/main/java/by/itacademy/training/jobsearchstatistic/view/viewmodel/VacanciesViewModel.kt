package by.itacademy.training.jobsearchstatistic.view.viewmodel

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import by.itacademy.training.jobsearchstatistic.util.Event
import kotlinx.coroutines.Dispatchers

class VacanciesViewModel : ViewModel() {

    private var _vacanciesLiveData = MutableLiveData<Event<List<Vacancy>>>()
    val vacanciesLiveData = _vacanciesLiveData
    val database = VacanciesDatabase.getDatabase()
    val mapper = DtoMapperImpl()
    val repository = VacanciesRepositoryImpl(,mapper)

    fun fetchAllVacancies() {
        _vacanciesLiveData = liveData(Dispatchers.IO) {

        }
    }

}
