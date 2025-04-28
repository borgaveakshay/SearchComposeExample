package com.assignment.achmeaassignment.data.di

import com.assignment.achmeaassignment.data.repository.EmployerRepositoryImpl
import com.assignment.achmeaassignment.data.service.EmployersService
import com.assignment.achmeaassignment.domain.EmployersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun getEmployerRepository(employersService: EmployersService): EmployersRepository =
        EmployerRepositoryImpl(employersService)
}