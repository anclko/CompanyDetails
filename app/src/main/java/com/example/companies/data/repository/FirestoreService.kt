package com.example.companies.data.repository

import com.example.companies.data.model.Company
import com.example.companies.data.model.CompanyResponse

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreService {
    //set up the database
    private val firestore = FirebaseFirestore.getInstance()

    //setting up the fetching
    suspend fun getCompanies(): CompanyResponse {
        return try {
            val companies = firestore.collection("companies")
                //fetch the document with nonblock
                .get()
                .await()
                //converts into objects and maps it to the right variables
                .toObjects(Company::class.java)
            //returns list in companyResponse format
            CompanyResponse(companies)
        } catch (e: Exception){
            CompanyResponse(emptyList())
        }
    }
}