package com.example.currencyinvestments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel.CoinsListViewModel
import com.example.currencyinvestments.presentation.ui.theme.CurrencyInvestmentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyInvestmentsTheme {
                val viewModel = hiltViewModel<CoinsListViewModel>()

              //  Greeting(name = state.coins[0].name)

            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = " $name")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CurrencyInvestmentsTheme {
            Greeting("Android")
        }
    }
}