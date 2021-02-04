package by.itacademy.training.jobsearchstatistic.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "vacancies")
data class VacancyDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Date?,
    val company: String?,
    val source: VacancyResource?,
    val sourcePerson: String?,
    var status: VacancyStatus?
)
