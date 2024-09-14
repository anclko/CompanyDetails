package com.example.companies.data.model

data class Company(
    val id: Int = 0,
    val title: String = "",
    val city: String = "",
    val webpage: String = "",
)

data class CompanyResponse(
    val companies: List<Company>
)