package com.assignment.achmeaassignment.domain.usecase

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.domain.EmployerInfo

import com.assignment.achmeaassignment.domain.EmployersRepository
import com.assignment.achmeaassignment.domain.usecase.utils.getMockData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class GetEmployersUseCaseTest {

    private lateinit var getEmployersUseCase: GetEmployersUseCase
    private val repository: EmployersRepository = mockk()

    @Before
    fun setUp() {
        getEmployersUseCase = GetEmployersUseCase(repository)
    }

    @Test
    fun `given successful search query for employer search`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val successResponse = getMockData(givenSearchQuery)
        coEvery { repository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Success(successResponse)
        }
        // WHEN
        val result = getEmployersUseCase(givenSearchQuery)

        // THEN
        result.collect { response ->
            response.apply {
                assert(this is ResultResource.Success)
                assert(data == successResponse)
            }
        }
    }

    @Test
    fun `given unsuccessful search query for employer search`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val errorMessage = "Something went Wrong"
        coEvery { repository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Error<EmployerInfo>(Exception(errorMessage))
        }
        // WHEN
        val result = getEmployersUseCase(givenSearchQuery)

        // THEN
        result.collect { response ->
            response.apply {
                assert(this is ResultResource.Error)
                assert(data == null)
                assert(errorMessage == errorMessage)
            }
        }
    }

    @Test
    fun `given loading state for employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        coEvery { repository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Loading<List<EmployerInfo>>(isLoading = true)
        }
        // WHEN
        val result = getEmployersUseCase(givenSearchQuery)

        // THEN
        result.collect { response ->
            response.apply {
                assert(this is ResultResource.Loading)
                assert(data == null)
                assert(errorMessage == null)
                assert(isLoading)
            }
        }
    }
}