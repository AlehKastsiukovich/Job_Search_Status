package by.itacademy.training.jobsearchstatistic.model.dto

import java.util.Date

data class JobDto(
    val date: Date,
    val company: String,
    val resource: JobResource,
    val resourceName: String,
    val status: JobStatus
)
