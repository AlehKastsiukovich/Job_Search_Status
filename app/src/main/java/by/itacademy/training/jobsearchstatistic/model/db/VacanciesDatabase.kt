package by.itacademy.training.jobsearchstatistic.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyDto
import by.itacademy.training.jobsearchstatistic.util.DateTypeConverter
import by.itacademy.training.jobsearchstatistic.util.EnumConverter

@Database(entities = [VacancyDto::class], version = 1)
@TypeConverters(DateTypeConverter::class, EnumConverter::class)
abstract class VacanciesDatabase : RoomDatabase() {

    abstract fun vacanciesDao(): VacanciesDao
}
