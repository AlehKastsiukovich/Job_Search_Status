package by.itacademy.training.jobsearchstatistic.util

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto

interface DtoMapper {

    fun fromDto(list: List<VacancyDto>): List<Vacancy>

    fun vacancyToVacancyDto(vacancy: Vacancy): VacancyDto

    fun mapToVacancy(vacancyDto: VacancyDto): Vacancy
}
