package com.example.companies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.companies.screens.CompanyScreen
import com.example.companies.ui.theme.CompaniesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompaniesTheme {
                CompanyScreen()
            }
        }
    }
}