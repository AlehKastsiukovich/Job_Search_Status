package by.itacademy.training.jobsearchstatistic.di

import by.itacademy.training.jobsearchstatistic.ui.viewmodel.VacanciesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        VacanciesViewModel(get())
    }
}
