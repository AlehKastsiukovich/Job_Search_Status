package by.itacademy.training.jobsearchstatistic.model.repository

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import kotlinx.coroutines.flow.Flow

class VacanciesRepositoryImpl(private val dao: VacanciesDao) : VacanciesRepository {

    override fun getAllVacancies(): Flow<Vacancy> {

    }
}
