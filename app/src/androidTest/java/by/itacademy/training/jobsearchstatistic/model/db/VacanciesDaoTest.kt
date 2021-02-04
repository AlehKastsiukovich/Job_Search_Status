package by.itacademy.training.jobsearchstatistic.model.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class VacanciesDaoTest {

    private lateinit var database: VacanciesDatabase
    private lateinit var dao: VacanciesDao

    @Before
    fun initDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            VacanciesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.vacanciesDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertVacancyDtoTest() = runBlocking {
        val vacancy = buildTestedVacancyDto()
        dao.insertVacancy(vacancy)

        val list = dao.getAllVacancies().first()
        assertThat(list).contains(vacancy)
    }

    @Test
    fun getItemById_mustReturnRightVacancy() = runBlocking {
        val exceptedVacancy = buildTestedVacancyDto()
        dao.insertVacancy(exceptedVacancy)

        val givenVacancy = dao.getItemById(1)
        assertThat(exceptedVacancy).isEqualTo(givenVacancy)
    }

    @Test
    fun updateVacancy_mustUpdateRightObject() = runBlocking {
        val startedObject = buildTestedVacancyDto()
        dao.insertVacancy(startedObject)

        val givenObject = dao.getItemById(1)
        givenObject.status = VacancyStatus.DECLINE_ANSWER
        dao.updateVacancy(givenObject)

        val result = dao.getItemById(1)
        assertThat(startedObject).isNotEqualTo(result)
    }

    @Test
    fun getRightNumberElementFromDatabase() = runBlocking {
        val givenVacancies = buildListVacancies()
        givenVacancies.forEach {
            dao.insertVacancy(it)
        }

        val result = dao.getAllVacancies().first()
        assertThat(givenVacancies.size).isEqualTo(result.size)
    }

    private fun buildTestedVacancyDto(): VacancyDto = VacancyDto(
        1,
        Date(),
        "Godel",
        VacancyResource.LinkedIn,
        "Ekaterina",
        VacancyStatus.DONE
    )

    private fun buildListVacancies(): List<VacancyDto> {
        val list = mutableListOf<VacancyDto>()
        val firstVacancy = VacancyDto(
            1,
            Date(),
            "Godel",
            VacancyResource.LinkedIn,
            "Ekaterina",
            VacancyStatus.DONE
        )
        val secondVacancy = VacancyDto(
            2,
            Date(),
            "EPAM",
            VacancyResource.LinkedIn,
            "Elizabeth",
            VacancyStatus.DECLINE
        )
        list.add(firstVacancy)
        list.add(secondVacancy)
        return list
    }
}
