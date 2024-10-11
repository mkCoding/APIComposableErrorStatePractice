package com.example.apicomposableerrorstatepractice.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicomposableerrorstatepractice.Resource
import com.example.apicomposableerrorstatepractice.application.LocationUseCase
import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZipDataViewModel @Inject constructor(
    private val locationUseCase: LocationUseCase
) : ViewModel(
) {

    private val _zipCodeState = MutableStateFlow<Resource<LocationZipCodeModel>?>(null)
    val zipCodeState: StateFlow<Resource<LocationZipCodeModel>?> = _zipCodeState


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchZipCodeData() {
        viewModelScope.launch {
            _isLoading.value = true
            locationUseCase.fetchZipData().collect { result ->
                // Assign the collected Resource<LocationZipCodeModel?> directly to _zipCodeState
                _zipCodeState.value = result
                // At the end, set loading state to false
                _isLoading.value = false
            }
        }
    }
}