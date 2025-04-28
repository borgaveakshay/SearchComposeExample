package com.assignment.achmeaassignment.data

import java.lang.Exception

sealed class ResultResource<T> {
    data object Loading: ResultResource<Nothing>()
    data class Error<T>(val exception: Exception): ResultResource<T>()
    data class Success<T>(val data: T): ResultResource<T>()
}