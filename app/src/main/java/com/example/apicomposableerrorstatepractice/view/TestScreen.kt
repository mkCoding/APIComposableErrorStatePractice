package com.example.apicomposableerrorstatepractice.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apicomposableerrorstatepractice.Resource
import com.example.apicomposableerrorstatepractice.dataaccess.model.LocationZipCodeModel

@Composable
fun TestScreen(viewModel: ZipDataViewModel = hiltViewModel()){
    val zipCodeState by viewModel.zipCodeState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchZipCodeData()
    }
    if (isLoading) {
        LoadingScreen()
    } else {
        when (zipCodeState) {
            is Resource.Success -> {
                SuccessScreen(data = (zipCodeState as Resource.Success).data)
            }
            is Resource.Failure-> {
                ErrorScreen(message = (zipCodeState as Resource.Failure).message)
            }
            else -> {
                // Initial or empty state
                InitialScreen()
            }
        }
    }


}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun SuccessScreen(data: LocationZipCodeModel?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Success Page",
                style = TextStyle(fontSize = 40.sp, fontStyle = FontStyle.Italic)
            )
            Text(text = "Data loaded successfully: ${data?.places}", textAlign = TextAlign.Center)
        }

    }
}

@Composable
fun ErrorScreen(message: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()

        ) {
           Text(
               text = "Error Page",
               style = TextStyle(fontSize = 40.sp, fontStyle = FontStyle.Italic)
           )


            Text(text = "An error occurred: $message", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Add retry logic here */ }) {
                Text(text = "Retry")
            }
        }
    }
}

@Composable
fun InitialScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Please initiate the data fetch.")
    }
}


@Composable
fun PreviewTestScreen(){
    TestScreen()
}