package by.itacademy.training.jobsearchstatistic.domain

data class Vacancy(
    val date: String,
    val company: String,
    val source: String,
    val sourcePerson: String?,
    val status: String
)
