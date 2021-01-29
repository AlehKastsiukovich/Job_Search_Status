package by.itacademy.training.jobsearchstatistic.util

import android.os.Build
import androidx.annotation.RequiresApi
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import java.text.SimpleDateFormat

class DtoMapperImpl : DtoMapper {

    override fun fromDto(list: List<VacancyDto>): List<Vacancy> {
        val vacancyList = mutableListOf<Vacancy>()
        list.forEach { dto ->
            vacancyList.add(
                Vacancy(
                    dto.id,
                    SimpleDateFormat("dd-MM-yyyy").format(dto.date),
                    dto.company ?: EMPTY_STRING,
                    dto.source?.name ?: EMPTY_STRING,
                    dto.sourcePerson ?: EMPTY_STRING,
                    dto.status?.name ?: EMPTY_STRING
                )
            )
        }
        return vacancyList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun vacancyToVacancyDto(vacancy: Vacancy): VacancyDto {
        return VacancyDto(
            id = vacancy.id,
            date = SimpleDateFormat("dd-MM-yyyy").parse(vacancy.date),
            company = vacancy.company,
            source = enumValueOf<VacancyResource>(vacancy.source),
            status = enumValueOf<VacancyStatus>(vacancy.status),
            sourcePerson = vacancy.sourcePerson
        )
    }

    override fun mapToVacancy(vacancyDto: VacancyDto) =
        Vacancy(
            vacancyDto.id,
            SimpleDateFormat("dd-MM-yyyy").format(vacancyDto.date),
            vacancyDto.company ?: EMPTY_STRING,
            vacancyDto.source?.name ?: EMPTY_STRING,
            vacancyDto.sourcePerson ?: EMPTY_STRING,
            vacancyDto.status?.name ?: EMPTY_STRING
        )

    companion object {
        private const val EMPTY_STRING = ""
    }
}
