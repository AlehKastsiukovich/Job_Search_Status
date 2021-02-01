package by.itacademy.training.jobsearchstatistic.di

import by.itacademy.training.jobsearchstatistic.ui.adapter.OnVacancyClickListener
import by.itacademy.training.jobsearchstatistic.ui.adapter.VacancyAdapter
import by.itacademy.training.jobsearchstatistic.ui.view.AllVacanciesFragment
import org.koin.dsl.module

val fragmentModule = module {
    scope<AllVacanciesFragment> {
        scoped { (onVacancyClickListener: OnVacancyClickListener) ->
            VacancyAdapter(onVacancyClickListener)
        }
    }
}
