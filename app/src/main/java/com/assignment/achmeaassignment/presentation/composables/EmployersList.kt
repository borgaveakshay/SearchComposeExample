package com.assignment.achmeaassignment.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.achmeaassignment.domain.EmployerInfo

@Composable
fun EmployersList(employersList: List<EmployerInfo>) {
    val employers = rememberSaveable { mutableStateOf(employersList) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),

    ) {
        LazyColumn(){
            items(items = employers.value, key = { item -> item.companyName }) {
                EmployerInfoItem(it)
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmployersListNightPreview() {
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
        )
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployersListPreview() {
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
        )
    )
}