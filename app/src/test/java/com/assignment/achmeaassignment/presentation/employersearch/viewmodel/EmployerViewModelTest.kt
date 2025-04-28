package com.assignment.achmeaassignment.presentation.employersearch.viewmodel

import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.domain.EmployerInfo
import com.assignment.achmeaassignment.domain.EmployersRepository
import com.assignment.achmeaassignment.domain.usecase.GetEmployersUseCase
import com.assignment.achmeaassignment.utils.getMockData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmployerViewModelTest {

    @get:Rule
    val dispatcherRule: DispatcherRule = DispatcherRule()

    private lateinit var employerViewModel: EmployerViewModel
    private val employerRepository: EmployersRepository = mockk()
    private val getEmployersUseCase: GetEmployersUseCase = mockk()

    @Before
    fun setUp() {
        employerViewModel = EmployerViewModel(getEmployersUseCase = getEmployersUseCase)
    }

    @Test
    fun `When successful response received for the employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val givenSuccessFulMockResponse = getMockData(givenSearchQuery)
        coEvery { employerRepository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Success(givenSuccessFulMockResponse)
        }
        coEvery { getEmployersUseCase(givenSearchQuery) } returns flow {
            emit(ResultResource.Success(givenSuccessFulMockResponse))
        }
        // WHEN
        employerViewModel.searchEmployers(givenSearchQuery)
        delay(100)
        // THEN
        employerViewModel.employerSearchStateFlow.value.apply {
            assert(data == givenSuccessFulMockResponse)
            assert(!isLoading)
            assert(!isError)
            assert(errorMessage == null)
        }
    }

    @Test
    fun `When state is loading for the employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        coEvery { employerRepository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Loading<List<EmployerInfo>>(isLoading = true)
        }
        coEvery { getEmployersUseCase(givenSearchQuery) } returns flow {
            emit(ResultResource.Loading<List<EmployerInfo>>(isLoading = true))
        }
        // WHEN
        employerViewModel.searchEmployers(givenSearchQuery)
        delay(100)
        // THEN
        employerViewModel.employerSearchStateFlow.value.apply {
            assert(data == null)
            assert(isLoading)
            assert(!isError)
            assert(errorMessage == null)
        }
    }

    @Test
    fun `When caught exception for the employer search query`() = runTest {
        // GIVEN
        val givenSearchQuery = "am"
        val givenErrorMessage = "Something went wrong."
        coEvery { employerRepository.getSearchedEmployers(givenSearchQuery) } returns flow {
            ResultResource.Error<List<EmployerInfo>>(exception = Throwable(givenErrorMessage) )
        }
        coEvery { getEmployersUseCase(givenSearchQuery) } returns flow {
            emit(ResultResource.Error<List<EmployerInfo>>(exception = Throwable(givenErrorMessage)))
        }
        // WHEN
        employerViewModel.searchEmployers(givenSearchQuery)
        delay(100)
        // THEN
        employerViewModel.employerSearchStateFlow.value.apply {
            assert(data == null)
            assert(!isLoading)
            assert(isError)
            assert(errorMessage == givenErrorMessage)
        }
    }
}