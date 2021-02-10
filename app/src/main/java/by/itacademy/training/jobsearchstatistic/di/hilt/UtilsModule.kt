package by.itacademy.training.jobsearchstatistic.di.hilt

import by.itacademy.training.jobsearchstatistic.util.DtoMapper
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UtilsModule {

    @Binds
    @Singleton
    fun provideDtoMapper(dtoMapper: DtoMapperImpl): DtoMapper
}
