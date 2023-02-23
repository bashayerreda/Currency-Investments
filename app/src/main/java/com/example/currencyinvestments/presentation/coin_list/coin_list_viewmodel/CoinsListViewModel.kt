package com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.domain.use_cases.get_coins.InvokeSortedCoins
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val repo : CoinRepository, private val useCasesGetCoins : InvokeSortedCoins): ViewModel() {

    data class CoinListState(
        val isLoading: Boolean = false,
        val coins: List<Coin> = emptyList(),
        val error: String = "",
        val exception: String = ""
    )

    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()

    init {

        getSortedElements()
     //   getDataAfterDealWithWrapperClass()
    }


     fun getSortedElements() {
        viewModelScope.launch {
            useCasesGetCoins.sortCoins().catch {
                it
                print(it.message) }
                .collect { it }
        }
    }

    fun getDataAfterDealWithWrapperClass() {
        viewModelScope.launch {
            when (val response = repo.getCoins()) {
                is NetworkResults.Success -> println(CoinListState(coins = response.data))
                is NetworkResults.Error -> println(CoinListState(error = "${response.code} + ${response.message}"))
                is NetworkResults.Exception -> println(CoinListState(error = "\"${response.e.message}\""))

            }
        }

    }
}



