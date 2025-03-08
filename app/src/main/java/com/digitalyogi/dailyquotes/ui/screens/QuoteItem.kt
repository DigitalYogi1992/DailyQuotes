package com.digitalyogi.dailyquotes.ui.screens


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalyogi.dailyquotes.data.Quote
import com.digitalyogi.dailyquotes.viewmodel.QuoteViewModel



@Composable
fun QuoteItem(quote: Quote, viewModel: QuoteViewModel) {
    var isEditing by remember { mutableStateOf(false) }
    var updatedText by remember { mutableStateOf(quote.text) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF6DD5FA), Color(0xFF2980B9))
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .animateContentSize(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (isEditing) {
                OutlinedTextField(
                    value = updatedText,
                    onValueChange = { updatedText = it },
                    label = { Text("Edit Quote") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        viewModel.updateQuote(quote.copy(text = updatedText))
                        isEditing = false
                    }) {
                        Text("Save")
                    }
                    Button(onClick = { isEditing = false }) {
                        Text("Cancel")
                    }
                }
            } else {
                Text(
                    quote.text,
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { isEditing = true }) {
                        Text("Edit")
                    }
                    Button(onClick = { viewModel.deleteQuote(quote) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}
