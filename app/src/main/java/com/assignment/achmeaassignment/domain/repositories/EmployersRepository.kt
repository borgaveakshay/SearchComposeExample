package com.assignment.achmeaassignment.domain.repositories

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.domain.entities.EmployerInfo
import kotlinx.coroutines.flow.Flow

interface EmployersRepository {
    suspend fun getSearchedEmployers(searchQuery: String): Flow<ResultResource<List<EmployerInfo>>>
}