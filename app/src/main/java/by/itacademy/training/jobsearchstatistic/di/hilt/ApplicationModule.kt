package by.itacademy.training.jobsearchstatistic.di.hilt

import android.content.Context
import androidx.room.Room
import by.itacademy.training.jobsearchstatistic.constants.DATABASE_NAME
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDao
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VacanciesDatabase = Room.databaseBuilder(
        context,
        VacanciesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    fun provideDao(database: VacanciesDatabase): VacanciesDao = database.vacanciesDao()
}
