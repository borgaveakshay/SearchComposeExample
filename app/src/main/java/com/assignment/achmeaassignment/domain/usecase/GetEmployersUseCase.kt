package com.assignment.achmeaassignment.domain.usecase

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.domain.entities.EmployerInfo
import com.assignment.achmeaassignment.domain.repositories.EmployersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployersUseCase @Inject constructor(private val repository: EmployersRepository) {
    suspend operator fun invoke(searchQuery: String): Flow<ResultResource<List<EmployerInfo>>> =
        repository.getSearchedEmployers(searchQuery)
}