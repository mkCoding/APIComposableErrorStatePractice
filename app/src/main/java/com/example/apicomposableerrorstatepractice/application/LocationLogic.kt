package com.example.apicomposableerrorstatepractice.application

import com.example.apicomposableerrorstatepractice.Resource
import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel
import com.example.apicomposableerrorstatepractice.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class LocationLogic  @Inject constructor(
  private val repository: LocationRepository
):LocationUseCase{
    override fun fetchZipData(): Flow<Resource<LocationZipCodeModel>?> {
        return flow {
            val responseZipData = repository.getLocationDataBasedOnZip(
                zipCode = ""
            )

            if (responseZipData == null) {
                emit(Resource.Failure<LocationZipCodeModel>("Received null response from the repository"))
                return@flow
            }



            when (responseZipData) {
                is Resource.Success -> {
                    responseZipData.data?.let {
                        emit(Resource.Success(it)) // Emit the successful data
                    } ?: run {
                        // Emit an Empty state if the data is null
                            emit(Resource.Failure<LocationZipCodeModel>("Received empty response"))

                    }
                }
                is Resource.Failure -> {
                    emit(Resource.Failure("Failed to fetch Zip Data: ${responseZipData.message}", responseZipData.code, responseZipData.isNetworkError))
                }

                is Resource.Empty -> TODO()
            }
        }



    }

}
