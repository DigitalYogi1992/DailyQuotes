package com.digitalyogi.dailyquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.digitalyogi.dailyquotes.ui.screens.QuoteScreen
import com.digitalyogi.dailyquotes.ui.theme.DailyQuotesTheme
import com.digitalyogi.dailyquotes.viewmodel.QuoteViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyQuotesTheme {
                val viewModel: QuoteViewModel = koinViewModel()
                QuoteScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyQuotesTheme {
        val viewModel: QuoteViewModel = koinViewModel()
        QuoteScreen(viewModel)
    }
}