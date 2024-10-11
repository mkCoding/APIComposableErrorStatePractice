package com.example.apicomposableerrorstatepractice.di

import com.example.apicomposableerrorstatepractice.application.LocationLogic
import com.example.apicomposableerrorstatepractice.application.LocationUseCase
import com.example.apicomposableerrorstatepractice.dataaccess.respository.LocationDefaultRepository
import com.example.apicomposableerrorstatepractice.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class LocationServiceModule(
locationDefaultRepository: LocationDefaultRepository
):LocationRepository {

    @Binds
    abstract fun bindLocationServiceRepo(
        locationDefaultRepository: LocationDefaultRepository
    ):LocationRepository

    @Binds
    abstract fun bindLocationUseCase(
        locationLogic: LocationLogic
    ): LocationUseCase


}