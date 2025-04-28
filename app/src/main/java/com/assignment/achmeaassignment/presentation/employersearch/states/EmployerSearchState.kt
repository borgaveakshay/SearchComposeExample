package com.assignment.achmeaassignment.presentation.employersearch.states

import com.assignment.achmeaassignment.domain.EmployerInfo

data class EmployerSearchState(
    val isLoading: Boolean = false,
    val data: List<EmployerInfo>? = null,
    val isError: Boolean = false,
    val errorMessage: String? = null
)
