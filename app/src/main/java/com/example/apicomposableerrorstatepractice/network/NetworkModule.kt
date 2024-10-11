package com.example.apicomposableerrorstatepractice.network

import com.example.apicomposableerrorstatepractice.dataaccess.service.LocationApi
import com.example.apicomposableerrorstatepractice.dataaccess.service.LocationApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

@Provides
@Singleton
fun provideRetrofit():Retrofit{
    return Retrofit.Builder()
        .baseUrl(LocationApiDetails.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

    @Provides
    @Singleton
    fun provideLocationApi(retrofit: Retrofit): LocationApi {
        return retrofit.create(LocationApi::class.java)
    }

}

