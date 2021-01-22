package by.itacademy.training.jobsearchstatistic.model.repository

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.util.DtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class VacanciesRepositoryImpl(
    private val dao: VacanciesDao,
    private val dtoMapper: DtoMapper
) : VacanciesRepository {

    override fun getAllVacancies() =
        dao.getAllVacancies().map { dtoMapper.fromDto(it) }.flowOn(Dispatchers.IO)

    override suspend fun addVacancy(vacancy: Vacancy) =
        dao.insertVacancy(dtoMapper.vacancyToVacancyDto(vacancy))
}
