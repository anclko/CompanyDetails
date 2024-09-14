package com.example.companies.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.example.companies.viewmodel.MainViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CompanyScreen(viewModel: MainViewModel = viewModel()){
    val state = viewModel.companiesState.value

    //loading visuals
    if (state.loading){
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text("Loading...")
        }
    }

    //handles error if loading fails
    state.error?.let{
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text("Error: $it")
        }
    }

    //handles successful retrieval
}

//function that formats the list presented