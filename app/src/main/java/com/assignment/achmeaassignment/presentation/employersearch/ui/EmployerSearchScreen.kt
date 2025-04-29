package com.assignment.achmeaassignment.presentation.employersearch.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.assignment.achmeaassignment.domain.EmployerInfo
import com.assignment.achmeaassignment.presentation.composables.EmployerSearchField
import com.assignment.achmeaassignment.presentation.composables.EmployersList
import com.assignment.achmeaassignment.presentation.employersearch.states.EmployerSearchState
import com.assignment.achmeaassignment.presentation.routes.EmployerDetailsRoute
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployerSearchScreen(
    navController: NavController,
    onSearchQueryChanged: (String) -> Unit,
    employerSearchState: State<EmployerSearchState>
) {
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(10.dp)
        ) {
            EmployerSearchField { searchQuery ->
                onSearchQueryChanged(searchQuery)
            }
            Spacer(modifier = Modifier.height(20.dp))
            employerSearchState.value.apply {
                if (!isError && !isLoading && data != null) {
                    when {
                        data.isEmpty() -> {
                            Text(
                                text = "No employers found",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                            )
                        }

                        else -> {
                            EmployersList(
                                employersList = data
                            ) { employerInfo ->
                                navController.navigate(
                                    EmployerDetailsRoute(
                                        companyName = employerInfo.companyName
                                    )
                                )
                            }
                        }
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        when {
                            !errorMessage.isNullOrEmpty() && isError -> {
                                Text(
                                    text = errorMessage,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }

                            isLoading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .size(50.dp)
                                )
                            }


                        }
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmployerSearchScreenNightPreview() {
    AppTheme {
        Surface {
            EmployerSearchScreen(
                onSearchQueryChanged = {},
                employerSearchState = remember {
                    mutableStateOf(
                        EmployerSearchState(
                            isLoading = false,
                            isError = true,
                            errorMessage = "Something went wrong",
                            data = null
                        )
                    )
                },
                navController = rememberNavController()
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployerSearchScreenPreview() {
    AppTheme {
        Surface {
            EmployerSearchScreen(
                onSearchQueryChanged = {},
                employerSearchState = remember {
                    mutableStateOf(
                        EmployerSearchState(
                            isLoading = false,
                            isError = false,
                            errorMessage = null,
                            data = listOf(
                                EmployerInfo(
                                    discountPercentage = 10,
                                    companyName = "company name 1",
                                    location = "location 1"
                                ),
                                EmployerInfo(
                                    discountPercentage = 20,
                                    companyName = "company name 2",
                                    location = "location 2"
                                )
                            )
                        )
                    )
                },
                navController = rememberNavController()
            )
        }
    }
}