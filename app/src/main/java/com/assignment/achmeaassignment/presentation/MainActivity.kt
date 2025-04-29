package com.assignment.achmeaassignment.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.assignment.achmeaassignment.presentation.employersearch.ui.EmployerSearchScreen
import com.assignment.achmeaassignment.presentation.employersearch.viewmodel.EmployerViewModel
import com.assignment.achmeaassignment.presentation.routes.EmployerScreenRoute
import com.example.compose.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Employer Search",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                        )
                    })
                { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        val employerViewModel: EmployerViewModel by viewModels()
                        NavHost(
                            navController = navController,
                            startDestination = EmployerScreenRoute
                        ) {
                            composable<EmployerScreenRoute> {
                                val employerState =
                                    employerViewModel.employerSearchStateFlow.collectAsStateWithLifecycle()
                                EmployerSearchScreen(
                                    onSearchQueryChanged = { employerViewModel.searchEmployers(it) },
                                    employerSearchState = employerState.value
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
