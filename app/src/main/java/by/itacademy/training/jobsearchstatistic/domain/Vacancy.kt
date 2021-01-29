package by.itacademy.training.jobsearchstatistic.domain

data class Vacancy(
    var id: Int,
    var date: String,
    var company: String,
    var source: String,
    var sourcePerson: String?,
    var status: String
)
