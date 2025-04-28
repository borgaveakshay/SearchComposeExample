package com.assignment.achmeaassignment.data

sealed class ResultResource<T>(
    val data: T?,
    val errorMessage: String?,
    open val isLoading: Boolean
) {
    data class Loading<T>(override val isLoading: Boolean) :
        ResultResource<T>(data = null, errorMessage = null, isLoading = false)

    data class Error<T>(val exception: Exception) :
        ResultResource<T>(data = null, errorMessage = exception.message, isLoading = false)

    data class Success<T>(val successResponse: T) :
        ResultResource<T>(data = successResponse, errorMessage = null, isLoading = false)
}