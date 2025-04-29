package com.assignment.achmeaassignment.presentation.routes

import kotlinx.serialization.Serializable

@Serializable
object EmployerScreenRoute

@Serializable
data class EmployerDetailsRoute(val companyName: String)