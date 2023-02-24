package com.example.currencyinvestments.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.currencyinvestments.Screens
import com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel.CoinsListViewModel

@Composable
fun MainCoinList(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModelState: CoinsListViewModel.CoinListState) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(viewModelState.coins){ coins ->
                CoinsListElements(  onItemClick = {
                    navController.navigate(Screens.DetailsScreen.route + "/${coins.id}")
                }, coin = coins)

            }
        }
        if (viewModelState.error != null){
      Text(text = viewModelState.error,
       style = MaterialTheme.typography.body1,
          textAlign = TextAlign.Center,
         color = Color.Red,
       modifier = Modifier.align(Alignment.Center).padding(4.dp)
    )

        }
        if (viewModelState.isLoading){
            CircularProgressIndicator(modifier= Modifier
                .align(Alignment.Center))
        }

    }
}