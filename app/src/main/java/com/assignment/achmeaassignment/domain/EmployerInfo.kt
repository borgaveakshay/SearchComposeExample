package com.assignment.achmeaassignment.domain

import androidx.compose.runtime.Stable

@Stable
data class EmployerInfo(
    val discountPercentage: Int,
    val companyName: String,
    val location: String
)
