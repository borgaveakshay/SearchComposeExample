package com.assignment.achmeaassignment.domain.usecase

import com.assignment.achmeaassignment.domain.EmployersRepository
import javax.inject.Inject

class GetEmployersUseCase @Inject constructor(private val repository: EmployersRepository) {
    suspend operator fun invoke(searchQuery: String) = repository.getSearchedEmployers(searchQuery)
}