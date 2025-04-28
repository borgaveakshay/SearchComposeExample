package com.assignment.achmeaassignment.domain

import com.assignment.achmeaassignment.data.common.ResultResource
import kotlinx.coroutines.flow.Flow

interface EmployersRepository {
    suspend fun getSearchedEmployers(searchQuery: String): Flow<ResultResource<List<EmployerInfo>>>
}