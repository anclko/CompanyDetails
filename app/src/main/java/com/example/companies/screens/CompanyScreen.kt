package com.example.companies.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import com.example.companies.viewmodel.MainViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.companies.data.model.Company

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

    //handles successful retrieval and presents the list
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
        items(state.list){ company ->
            CompanyCard(company = company)
        }
    }
}

//function that formats the list presented
@Composable
fun CompanyCard(company: Company){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
        ){
            Text(
                text = company.title
            )

            Text(
                text = company.city
            )

            Text(
                text = company.webpage
            )
        }
    }
}