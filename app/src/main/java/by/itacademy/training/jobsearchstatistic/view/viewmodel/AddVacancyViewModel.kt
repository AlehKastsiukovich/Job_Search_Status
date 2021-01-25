package by.itacademy.training.jobsearchstatistic.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.util.Event

class AddVacancyViewModel : ViewModel() {

    private var _vacancy: LiveData<Event<Vacancy>> = MutableLiveData()
    val vacancy: LiveData<Event<Vacancy>> = _vacancy


}
