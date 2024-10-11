package com.example.apicomposableerrorstatepractice.domain.repository

import com.example.apicomposableerrorstatepractice.Resource
import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel

interface LocationRepository {
    suspend fun getLocationDataBasedOnZip(
        zipCode:String
    ): Resource<LocationZipCodeModel?>

}