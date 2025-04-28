package com.assignment.achmeaassignment.data.repository

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.data.response.EmployersResponse
import com.assignment.achmeaassignment.data.response.toEmployerInfo
import com.assignment.achmeaassignment.data.service.EmployersService
import com.assignment.achmeaassignment.domain.EmployerInfo
import com.assignment.achmeaassignment.domain.usecase.utils.getMockData
import com.assignment.achmeaassignment.domain.usecase.utils.getMockNetworkData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class EmployerRepositoryImplTest {

    private val employersService: EmployersService = mockk()
    private lateinit var employerRepositoryImpl: EmployerRepositoryImpl

    @Before
    fun setUp() {
        employerRepositoryImpl = EmployerRepositoryImpl(employersService)
    }

    @Test
    fun `when successful response for employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val successfulNetworkResponse = getMockNetworkData()
        val successResponse = successfulNetworkResponse.toEmployerInfo()
        coEvery {
            employersService.getEmployers(
                searchQuery = givenSearchQuery,
                maxRows = 100
            )
        } returns successfulNetworkResponse
        // WHEN
        val result = employerRepositoryImpl.getSearchedEmployers(givenSearchQuery)
        // THEN
        result.collect { response ->
            response.apply {
                assert(this is ResultResource.Success)
                assert(data == successResponse)
            }
        }
    }

    @Test
    fun `when error response occurs for employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val givenErrorMessage = "Something went wrong"
        val expectedError = Throwable(givenErrorMessage)
        coEvery {
            employersService.getEmployers(
                searchQuery = givenSearchQuery,
                maxRows = 100
            )
        } throws expectedError
        // WHEN
        val result = employerRepositoryImpl.getSearchedEmployers(givenSearchQuery)
        // THEN
        result.collect { response ->
            response.apply {
                assert(this is ResultResource.Error)
                assert(data == null)
                assert(!isLoading)
                assert(errorMessage == givenErrorMessage)
            }
        }
    }
}

