package com.example.apicomposableerrorstatepractice.dataaccess.respository

import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel
import com.example.apicomposableerrorstatepractice.dataaccess.service.LocationApi
import com.example.apicomposableerrorstatepractice.domain.repository.LocationRepository
import com.example.apicomposableerrorstatepractice.Resource
import javax.inject.Inject

class LocationDefaultRepository @Inject constructor(
    private val locationApi: LocationApi
):LocationRepository{
    // Zip Data
    override suspend fun getLocationDataBasedOnZip(zipCode: String): Resource<LocationZipCodeModel?> {
        // Implement the method to fetch location data based on the ZIP code
            return try {
                // Make the API call to fetch location data
                val response = locationApi.getZipCodeDataBasedOnZip(zipCode)

                // Check if the response is successful
                if (response.isSuccessful) {
                    // Get the body of the response
                    val locationData = response.body()
                    // Return a success Resource with the location data

                  Resource.Success(locationData)
                } else {

                    val errorBody = response.errorBody()?.string()
                    println("API Error: $errorBody, Status Code: ${response.code()}")
                    // Return a failure Resource with an error message
                    Resource.Failure("Failed to fetch location data: ${response.errorBody()?.string()}", response.code())
                }
            } catch (e: Exception) {

                println("====Exception occurred: ${e.message}")
                // Return a failure Resource if an exception occurs
                Resource.Failure("An error occurred: ${e.message}", null, true)
            }

    }
}
