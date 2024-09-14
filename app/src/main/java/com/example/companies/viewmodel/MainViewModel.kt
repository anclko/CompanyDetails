package com.example.companies.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companies.data.model.Company
import com.example.companies.data.repository.FirestoreService
import kotlinx.coroutines.launch

//inherits viewModel() for data persistence
class MainViewModel(private val firestoreService: FirestoreService = FirestoreService()): ViewModel() {
    private val _companiesState = mutableStateOf(CompanyState())
    val companiesState: State<CompanyState> = _companiesState

    init {
        fetchCompanies()
    }

    //fetch categories from firestore
    private fun fetchCompanies(){
        //this starts the process of getting the data in coroutine
        viewModelScope.launch{
            try {
                val response = firestoreService.getCompanies()
                _companiesState.value = _companiesState.value.copy(
                    //if successful saves it to list, stops loading and no error
                    list = response.companies,
                    loading = false,
                    error = null
                )
            } catch (e: Exception){
                _companiesState.value = _companiesState.value.copy(
                    loading = false,
                    error = "Error retrieving the companies: ${e.message}"
                )
            }
        }
    }

    data class CompanyState(
        val loading: Boolean = true,
        val list: List<Company> = emptyList(),
        val error: String? = null
    )
}

