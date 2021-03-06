package by.itacademy.training.jobsearchstatistic.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepository
import by.itacademy.training.jobsearchstatistic.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class VacanciesViewModel(private val repository: VacanciesRepository) : ViewModel() {

    private var _vacanciesLiveData = MutableLiveData<Event<List<Vacancy>>>()
    val vacanciesLiveData: LiveData<Event<List<Vacancy>>> = _vacanciesLiveData
    var vacancy: LiveData<Event<Vacancy>> = MutableLiveData()

    init {
        fetchAllVacancies()
    }

    fun addVacancy(vacancy: Vacancy) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVacancy(vacancy)
        }
    }

    fun getVacancyById(id: Int) {
        vacancy = liveData {
            emit(Event.loading(null))
            try {
                val result = repository.getVacancyById(id)
                emit(Event.success(result))
            } catch (e: Exception) {
                emit(Event.error(null, e.message))
            }
        }
    }

    fun updateVacancy(updatedVacancy: Vacancy) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateVacancy(updatedVacancy)
        }
    }

    private fun fetchAllVacancies() {
        viewModelScope.launch {
            repository.getAllVacancies()
                .onStart { _vacanciesLiveData.value = Event.loading(null) }
                .catch { _vacanciesLiveData.value = Event.error(null, null) }
                .collect { _vacanciesLiveData.value = Event.success(it) }
        }
    }
}
