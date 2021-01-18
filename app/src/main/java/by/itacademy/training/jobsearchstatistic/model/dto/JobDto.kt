package by.itacademy.training.jobsearchstatistic.model.dto

import java.util.Date

data class JobDto(
    val date: Date?,
    val company: String?,
    val source: JobResource?,
    val sourcePerson: String?,
    val status: JobStatus?
)
