package com.example.currencyinvestments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.presentation.coin_details.components.CoinDetailScreen
import com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel.CoinsListViewModel

import com.example.currencyinvestments.presentation.coin_list.components.MainCoinList
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
                val state by viewModel.state.collectAsState()
                val navController = rememberNavController()
                Navigation(navController = navController)

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
