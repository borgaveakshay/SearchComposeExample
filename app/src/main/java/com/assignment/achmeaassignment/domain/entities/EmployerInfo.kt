package com.assignment.achmeaassignment.domain.entities

import androidx.compose.runtime.Stable

@Stable
data class EmployerInfo(
    val discountPercentage: Int,
    val companyName: String,
    val location: String
)