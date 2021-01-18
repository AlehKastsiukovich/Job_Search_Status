package by.itacademy.training.jobsearchstatistic.model.dto

import java.util.Date

data class VacancyDto(
    val date: Date?,
    val company: String?,
    val source: VacancyResource?,
    val sourcePerson: String?,
    val status: VacancyStatus?
)
