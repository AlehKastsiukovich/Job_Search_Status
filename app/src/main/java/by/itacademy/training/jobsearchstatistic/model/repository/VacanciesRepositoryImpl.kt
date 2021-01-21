package by.itacademy.training.jobsearchstatistic.model.repository

import android.util.Log
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
            Log.d("TAGG", vacanciesDto.toString())
            dtoMapper.fromDto(vacanciesDto)
        }
    }

    override suspend fun addVacancy(vacancy: Vacancy) =
        dao.insertVacancy(dtoMapper.vacancyToVacancyDto(vacancy))
}
