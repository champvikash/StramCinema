package com.example.streamcinema.utils

sealed class Res<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Res<T>(data)
    class Loading<T> : Res<T>()
    class Error<T>(message: String, data: T? = null) :
        Res<T>(data, message)
}