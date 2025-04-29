package com.assignment.achmeaassignment.presentation.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmployerSearchField(onQueryChanged: (String) -> Unit) {
    val searchQuery = remember { mutableStateOf("") }
    Card (modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(8.dp)
    ) {
        TextField(
            value = searchQuery.value,
            onValueChange = {
                searchQuery.value = it
                onQueryChanged(it)
            },
            label = { Text("Search Employers") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            },
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EmployerSearchNightFieldPreview() {
    EmployerSearchField(onQueryChanged = {})
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EmployerSearchFieldPreview() {
    EmployerSearchField(onQueryChanged = {})
}



