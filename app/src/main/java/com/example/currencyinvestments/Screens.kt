package com.example.currencyinvestments

sealed class Screens(val route : String) {
    object MainCoinsList : Screens("main_coins_list_scr")
    object DetailsScreen : Screens("Details_screen")
}