package com.assignment.achmeaassignment.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignment.achmeaassignment.domain.entities.EmployerInfo
import com.example.compose.AppTheme

@Composable
fun EmployersList(employersList: List<EmployerInfo>, onEmployerInfoClick: (EmployerInfo) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        LazyColumn {
            items(items = employersList, key = { item -> item.companyName }) {
                EmployerInfoItem(it) { employerInfo ->
                    onEmployerInfoClick(employerInfo)
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployersListNightPreview() {
    AppTheme {
        Surface {
            EmployersList(
                employersList = listOf(
                    EmployerInfo(
                        discountPercentage = 10,
                        companyName = "Company Name 1",
                        location = "Location 1",
                    ),
                    EmployerInfo(
                        discountPercentage = 11,
                        companyName = "Company Name 2",
                        location = "Location 2",
                    )
                ),
                onEmployerInfoClick = {}
            )
        }
    }
}
