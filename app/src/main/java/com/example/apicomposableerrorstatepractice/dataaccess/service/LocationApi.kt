package com.example.apicomposableerrorstatepractice.dataaccess.service

import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LocationApi {

    @GET(LocationApiDetails.ENDPOINT_ZIPCODE_DETAILS)
    suspend fun getZipCodeDataBasedOnZip(
        @Path("zipCode") zipCode:String
    ): Response<LocationZipCodeModel?>
}