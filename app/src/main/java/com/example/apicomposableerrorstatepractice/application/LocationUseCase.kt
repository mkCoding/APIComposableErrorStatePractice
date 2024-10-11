package com.example.apicomposableerrorstatepractice.application

import com.example.apicomposableerrorstatepractice.Resource
import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel
import kotlinx.coroutines.flow.Flow

interface LocationUseCase {
    fun fetchZipData():Flow<Resource<LocationZipCodeModel>?>

}
