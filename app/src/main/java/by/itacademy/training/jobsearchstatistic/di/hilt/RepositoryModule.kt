package by.itacademy.training.jobsearchstatistic.di.hilt

import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepository
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideVacancyRepository(vacanciesRepository: VacanciesRepositoryImpl): VacanciesRepository
}
