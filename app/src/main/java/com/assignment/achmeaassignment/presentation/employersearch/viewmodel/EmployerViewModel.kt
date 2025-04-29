package com.assignment.achmeaassignment.presentation.employersearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.achmeaassignment.data.common.ResultResource
import com.assignment.achmeaassignment.domain.usecase.GetEmployersUseCase
import com.assignment.achmeaassignment.presentation.employersearch.states.EmployerSearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployerViewModel @Inject constructor(
    private val getEmployersUseCase: GetEmployersUseCase
) : ViewModel() {

    val employerSearchStateFlow: StateFlow<EmployerSearchState>
        field = MutableStateFlow(EmployerSearchState())

    fun searchEmployers(searchQuery: String) = viewModelScope.launch {
        getEmployersUseCase(searchQuery).collect { response ->
            when (response) {
                is ResultResource.Error -> {
                    employerSearchStateFlow.update {
                        it.copy(
                            isError = true,
                            errorMessage = response.errorMessage,
                            data = null,
                            isLoading = false
                        )
                    }
                }

                is ResultResource.Loading -> {
                    employerSearchStateFlow.update {
                        it.copy(
                            isLoading = true,
                            isError = false,
                            data = null,
                            errorMessage = null
                        )
                    }
                }

                is ResultResource.Success -> {
                    employerSearchStateFlow.update {
                        it.copy(
                            data = response.data,
                            isLoading = false,
                            isError = false,
                            errorMessage = null
                        )
                    }
                }
            }
        }
    }
}