package com.assignment.achmeaassignment.data.service

import com.assignment.achmeaassignment.data.response.EmployersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EmployersService {
    @GET("/rest/employers")
    fun getEmployers(
        @Query("filter") searchQuery: String,
        @Query("maxRows") maxRows: Int
    ): EmployersResponse?
}