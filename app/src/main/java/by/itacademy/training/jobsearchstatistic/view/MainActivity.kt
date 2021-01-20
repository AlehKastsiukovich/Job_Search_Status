package by.itacademy.training.jobsearchstatistic.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val vacancy = Vacancy(
//            "21-01-2021",
//            "SolbegSoft",
//            VacancyResource.LINKED_IN.name,
//            "Hanna",
//            VacancyStatus.DONE.name
//        )
//
        val database = VacanciesDatabase.getDatabase(this)
        val dtoMapper = DtoMapperImpl()
        val repository = VacanciesRepositoryImpl(database.vacanciesDao(), dtoMapper)

        lifecycleScope.launch(Dispatchers.IO) {
            repository.getAllVacancies().collect {
                val res = it
                Log.d("TAGG", res.toString())
            }
        }
        val x = intent.extras
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            repository.addVacancy(vacancy)
//        }
    }
}
