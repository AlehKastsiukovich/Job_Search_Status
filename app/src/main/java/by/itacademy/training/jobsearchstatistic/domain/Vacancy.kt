package by.itacademy.training.jobsearchstatistic.domain

import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import java.util.Date

data class Vacancy(
    val date: Date,
    val company: String,
    val source: VacancyResource,
    val sourcePerson: String?,
    val status: VacancyStatus
)
