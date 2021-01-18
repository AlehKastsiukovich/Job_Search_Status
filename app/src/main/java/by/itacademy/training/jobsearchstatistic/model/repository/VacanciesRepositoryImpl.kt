package by.itacademy.training.jobsearchstatistic.model.repository

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.util.DtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VacanciesRepositoryImpl(
    private val dao: VacanciesDao,
    private val dtoMapper: DtoMapper
) : VacanciesRepository {

    override fun getAllVacancies(): Flow<List<Vacancy>> {
        return dao.getAllVacancies().map { vacanciesDto ->
            dtoMapper.fromDto(vacanciesDto)
        }
    }
}
