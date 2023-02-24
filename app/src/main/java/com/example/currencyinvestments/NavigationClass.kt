package com.example.currencyinvestments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.currencyinvestments.presentation.coin_details.components.CoinDetailScreen
import com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel.CoinsListViewModel
import com.example.currencyinvestments.presentation.coin_list.components.MainCoinList


@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController,
      startDestination = Screens.MainCoinsList.route,
      modifier = Modifier.fillMaxSize()
  ){
      composable(Screens.MainCoinsList.route){
          val viewModel = hiltViewModel<CoinsListViewModel>()
          val state by viewModel.state.collectAsState()
         MainCoinList(navController = navController, viewModelState = state)
      }
        composable(Screens.DetailsScreen.route+ "/{coinId}"){
            CoinDetailScreen()
        }

  }
}
