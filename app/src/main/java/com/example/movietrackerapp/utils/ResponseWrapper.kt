package com.example.movietrackerapp.utils

sealed class ResponseWrapper<T> {
    data class Success<T>(val data: T): ResponseWrapper<T>()
    data class Error<T>(val message: String): ResponseWrapper<T>()
    data class Loading<T>(val data: T? = null):ResponseWrapper<T>()
}