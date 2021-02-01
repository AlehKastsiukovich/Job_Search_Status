package by.itacademy.training.jobsearchstatistic.di

import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepository
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<VacanciesRepository> { VacanciesRepositoryImpl(get(), get()) }
}
