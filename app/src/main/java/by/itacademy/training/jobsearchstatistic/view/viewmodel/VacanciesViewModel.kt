package by.itacademy.training.jobsearchstatistic.view.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import by.itacademy.training.jobsearchstatistic.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class VacanciesViewModel(
    private val context: Context,
    private val dao: VacanciesDao,
    private val mapper: DtoMapperImpl,
    private val repository: VacanciesRepositoryImpl
) : ViewModel() {

    private var _vacanciesLiveData: LiveData<Event<List<Vacancy>>> = MutableLiveData<Event<List<Vacancy>>>()
    val vacanciesLiveData: LiveData<Event<List<Vacancy>>> = _vacanciesLiveData

    init {
        fetchAllVacancies()
    }

    fun addVacancy(vacancy: Vacancy) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVacancy(vacancy)
        }
    }

    private fun fetchAllVacancies() {
        _vacanciesLiveData = liveData(Dispatchers.IO) {
            try {
                repository.getAllVacancies()
                    .onStart { emit(Event.loading(null)) }
                    .collect { emit(Event.success(it)) }
            } catch (e: Exception) {
                emit(Event.error(null, e.message.toString()))
            }
        }
    }
}
