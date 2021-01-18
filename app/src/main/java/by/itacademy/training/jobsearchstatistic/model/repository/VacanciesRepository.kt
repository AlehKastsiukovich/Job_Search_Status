package by.itacademy.training.jobsearchstatistic.model.repository

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import kotlinx.coroutines.flow.Flow

interface VacanciesRepository {

    fun getAllVacancies(): Flow<Vacancy>
}
