package by.itacademy.training.jobsearchstatistic.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import kotlinx.coroutines.flow.Flow

@Dao
interface VacanciesDao {

    @Query("SELECT * FROM vacancies")
    fun getAllVacancies(): Flow<List<VacancyDto>>

    @Query("SELECT * FROM vacancies WHERE id = :id")
    suspend fun getItemById(id: Int): VacancyDto

    @Insert
    suspend fun insertVacancy(vacancyDto: VacancyDto)

    @Update
    suspend fun updateVacancy(vacancyDto: VacancyDto)
}
