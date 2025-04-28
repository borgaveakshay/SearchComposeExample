package com.assignment.achmeaassignment.presentation.employersearch.di

import com.assignment.achmeaassignment.domain.EmployersRepository
import com.assignment.achmeaassignment.domain.usecase.GetEmployersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun getEmployerSearchUseCase(repository: EmployersRepository): GetEmployersUseCase =
        GetEmployersUseCase(repository)
}
