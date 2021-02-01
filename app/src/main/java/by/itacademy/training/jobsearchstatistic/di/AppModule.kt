package by.itacademy.training.jobsearchstatistic.di

import android.content.Context
import androidx.room.Room
import by.itacademy.training.jobsearchstatistic.constants.DATABASE_NAME
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import by.itacademy.training.jobsearchstatistic.util.DtoMapper
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<DtoMapper> { return@single DtoMapperImpl() }
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
}

fun provideDatabase(context: Context): VacanciesDatabase =
    Room.databaseBuilder(
        context,
        VacanciesDatabase::class.java,
        DATABASE_NAME
    ).build()

fun provideDao(vacanciesDatabase: VacanciesDatabase): VacanciesDao = vacanciesDatabase.vacanciesDao()
