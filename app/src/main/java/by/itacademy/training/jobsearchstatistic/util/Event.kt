package by.itacademy.training.jobsearchstatistic.util

class Event<out T>(
    val data: T?,
    val message: String?,
    val status: Status
) {

    companion object {
        fun <T> success(data: T): Event<T> = Event(data, null, Status.SUCCESS)
        fun <T> loading(data: T?): Event<T> = Event(null, null, Status.LOADING)
        fun <T> error(data: T?, message: String?) = Event(null, message, Status.ERROR)
    }
}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}
