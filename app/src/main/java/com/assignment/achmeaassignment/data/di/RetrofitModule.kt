package com.assignment.achmeaassignment.data.di

import com.assignment.achmeaassignment.BuildConfig
import com.assignment.achmeaassignment.data.service.EmployersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun getEmployerService(retrofit: Retrofit): EmployersService =
        retrofit.create(EmployersService::class.java)
}