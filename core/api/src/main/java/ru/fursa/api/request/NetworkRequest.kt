package ru.fursa.api.request

sealed class NetworkRequest<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : NetworkRequest<T>(data)
    class Error<T>(message: String?, data: T? = null): NetworkRequest<T>(data, message)
    class Loading<T>(data: T? = null): NetworkRequest<T>(data)
}