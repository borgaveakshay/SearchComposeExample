package com.assignment.achmeaassignment.data.repository

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.data.response.toEmployerInfo
import com.assignment.achmeaassignment.data.service.EmployersService
import com.assignment.achmeaassignment.domain.EmployerInfo
import com.assignment.achmeaassignment.domain.EmployersRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@OptIn(FlowPreview::class)
class EmployerRepositoryImpl @Inject constructor(
    private val employersService: EmployersService
) : EmployersRepository {

    override suspend fun getSearchedEmployers(searchQuery: String): Flow<ResultResource<List<EmployerInfo>>> =
        flow<ResultResource<List<EmployerInfo>>> {
            val result = employersService.getEmployers(
                searchQuery = searchQuery,
                maxRows = 100
            )?.toEmployerInfo() ?: emptyList()
            emit(
                ResultResource.Success(
                    successResponse = result
                )
            )
        }.onStart {
            emit(ResultResource.Loading(isLoading = true))
        }.catch { exception ->
            emit(ResultResource.Error(exception = exception))
        }.debounce(1000L)

}