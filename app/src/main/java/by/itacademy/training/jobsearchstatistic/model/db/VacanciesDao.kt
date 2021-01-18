package by.itacademy.training.jobsearchstatistic.model.db

import androidx.room.Dao
import androidx.room.Query
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import kotlinx.coroutines.flow.Flow

@Dao
interface VacanciesDao {

    @Query("SELECT * FROM vacancies")
    fun getAllVacancies(): Flow<List<VacancyDto>>
}
