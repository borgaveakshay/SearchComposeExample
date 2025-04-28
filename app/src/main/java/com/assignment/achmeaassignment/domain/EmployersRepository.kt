package com.assignment.achmeaassignment.domain

import com.assignment.achmeaassignment.data.ResultResource
import kotlinx.coroutines.flow.Flow

interface EmployersRepository {
    suspend fun getSearchedEmployers(searchQuery: String): Flow<ResultResource<List<EmployerInfo>>>
}