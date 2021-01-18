package by.itacademy.training.jobsearchstatistic.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto

@Database(entities = [VacancyDto::class], version = 1)
abstract class VacanciesDatabase : RoomDatabase() {

    abstract fun vacanciesDao(): VacanciesDao

    companion object {
        const val DATABASE_NAME = "vacancies_db"
        fun getDatabase(context: Context): VacanciesDatabase =
            Room.databaseBuilder(
                context,
                VacanciesDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}
