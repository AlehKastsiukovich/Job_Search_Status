package by.itacademy.training.jobsearchstatistic.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.itacademy.training.jobsearchstatistic.domain.Vacancy

class VacanciesViewModel : ViewModel() {

    private var vacanciesLiveData = MutableLiveData<List<Vacancy>>()

}
