package by.itacademy.training.jobsearchstatistic.view.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VacanciesViewModel::class.java)) {
            return VacanciesViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}