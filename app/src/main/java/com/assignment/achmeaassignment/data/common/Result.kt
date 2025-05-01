package com.assignment.achmeaassignment.data.common

sealed class ResultResource<out T>(
    val data: T?,
    val errorMessage: String?
) {
    class Loading<out T>(data: T? = null) :
        ResultResource<T>(data = data, errorMessage = null)

    data class Error<out T>(val exception: Throwable) :
        ResultResource<T>(data = null, errorMessage = exception.message)

    data class  Success<out T>(val successResponse: T) :
        ResultResource<T>(data = successResponse, errorMessage = null)
}