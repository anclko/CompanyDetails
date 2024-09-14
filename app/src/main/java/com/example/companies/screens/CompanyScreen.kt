package com.example.companies.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.companies.viewmodel.MainViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .padding(top = 64.dp, start = 16.dp, end = 16.dp, bottom = 32.dp),
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
            .padding(16.dp)
            .shadow(8.dp),
        shape = RoundedCornerShape(12.dp),
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
        ){
            //title of company
            Text(
                text = company.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 22.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            //location
            Text(
                text = "Location: ${company.city}"
            )

            //webpage
            Text(
                text = "Webpage:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
            )

            Text(
                text = company.webpage,
                fontSize = 16.sp,
                color = Color(0xFF009688),
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}