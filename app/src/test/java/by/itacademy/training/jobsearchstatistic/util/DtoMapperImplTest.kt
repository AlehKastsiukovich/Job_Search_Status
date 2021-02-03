package by.itacademy.training.jobsearchstatistic.util

import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date

class DtoMapperImplTest {

    private val dtoMapper: DtoMapper = DtoMapperImpl()
    private val testedDtoList = mutableListOf<VacancyDto>()

    @Before
    fun initTestedList() {
        testedDtoList.add(
            VacancyDto(
                1,
                Date(),
                "Godel",
                VacancyResource.LinkedIn,
                "Ekaterina Shytikova",
                VacancyStatus.DONE
            )
        )
        testedDtoList.add(
            VacancyDto(
                2,
                Date(),
                "SolbegSoft",
                VacancyResource.LinkedIn,
                "Ann Hurkova",
                VacancyStatus.PROCESSING
            )
        )
    }

    @After
    fun clear() {
        testedDtoList.clear()
    }

    @Test
    fun `fromDto method must return same size list`() {
        val result = dtoMapper.fromDto(testedDtoList)
        assertEquals(testedDtoList.size, result.size)
    }

    @Test
    fun `fromDto method must return right data`() {
        val excepted = listOf(buildTestedVacancy())
        val tested = listOf(buildTestedVacancyDto())

        val result = dtoMapper.fromDto(tested)
        result.forEach {
            assertEquals(excepted[0].id, it.id)
            assertEquals(excepted[0].company, it.company)
            assertEquals(excepted[0].source, it.source)
            assertEquals(excepted[0].sourcePerson, it.sourcePerson)
            assertEquals(excepted[0].date, it.date)
            assertEquals(excepted[0].status, it.status)
        }
    }

    @Test
    fun `vacancyToVacancyDto must return right data`() {
        val excepted = buildTestedVacancyDto()
        val result = dtoMapper.vacancyToVacancyDto(buildTestedVacancy())
        assertEquals(excepted, result)
    }

    private fun buildTestedVacancyDto(): VacancyDto = VacancyDto(
        0,
        SimpleDateFormat("dd-MM-yyyy").parse(buildTestedVacancy().date),
        "Godel",
        VacancyResource.LinkedIn,
        "Ekaterina",
        VacancyStatus.DONE
    )

    private fun buildTestedVacancy(): Vacancy = Vacancy(
        0,
        "03-02-2021",
        "Godel",
        "LinkedIn",
        "Ekaterina",
        "DONE"
    )
}
