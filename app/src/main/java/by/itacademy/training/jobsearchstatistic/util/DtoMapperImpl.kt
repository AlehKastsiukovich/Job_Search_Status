package by.itacademy.training.jobsearchstatistic.util

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto

class DtoMapperImpl : DtoMapper {

    override fun fromDto(list: List<VacancyDto>): List<Vacancy> {
        val vacancyList = mutableListOf<Vacancy>()
        list.forEach { dto ->
            vacancyList.add(
                Vacancy(
                    dto.date.toString(),
                    dto.company ?: EMPTY_STRING,
                    dto.source?.name ?: EMPTY_STRING,
                    dto.sourcePerson ?: EMPTY_STRING,
                    dto.status?.name ?: EMPTY_STRING
                )
            )
        }
        return vacancyList
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}
