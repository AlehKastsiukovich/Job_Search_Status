package by.itacademy.training.jobsearchstatistic.util

import androidx.room.TypeConverter
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus

class EnumConverter {

    @TypeConverter
    fun sourceToString(source: VacancyResource?): String? = source?.name

    @TypeConverter
    fun stringToSource(string: String): VacancyResource = enumValueOf(string)

    @TypeConverter
    fun statusToString(status: VacancyStatus?): String? = status?.name

    @TypeConverter
    fun stringToStatus(string: String): VacancyStatus = enumValueOf(string)
}
