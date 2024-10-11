package com.example.apicomposableerrorstatepractice


sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null,
    val isNetworkError: Boolean = false
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Failure <T>(message: String, code: Int? = null, isNetworkError: Boolean = false) : Resource<T>(null, message, code, isNetworkError)
    class Empty<T>(message: String = "No data available") : Resource<T>(null, message)
}
