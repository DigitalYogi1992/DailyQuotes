package com.digitalyogi.dailyquotes.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.digitalyogi.dailyquotes.viewmodel.QuoteViewModel

@Composable
fun QuoteScreen(viewModel: QuoteViewModel) {
    val quotes by viewModel.allQuotes.observeAsState(emptyList())
    var text by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter Quote") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 64.dp) // Ensure space for the FloatingActionButton
                )
                FloatingActionButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            viewModel.addQuote(text); text = ""
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterEnd) // Align to the right
                ) {
                    Text("+")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(quotes) { quote ->
                    QuoteItem(quote, viewModel)
                }
            }
        }
    }
}
