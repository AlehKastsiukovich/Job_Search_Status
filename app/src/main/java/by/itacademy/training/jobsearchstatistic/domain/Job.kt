package by.itacademy.training.jobsearchstatistic.domain

import by.itacademy.training.jobsearchstatistic.model.dto.JobResource
import by.itacademy.training.jobsearchstatistic.model.dto.JobStatus
import java.util.Date

data class Job(
    val date: Date,
    val company: String,
    val source: JobResource,
    val sourcePerson: String?,
    val status: JobStatus
)
