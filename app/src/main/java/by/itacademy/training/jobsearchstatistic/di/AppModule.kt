package by.itacademy.training.jobsearchstatistic.di

import by.itacademy.training.jobsearchstatistic.util.DtoMapper
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import org.koin.dsl.module

val appModule = module {
    single<DtoMapper> { return@single DtoMapperImpl() }
}
