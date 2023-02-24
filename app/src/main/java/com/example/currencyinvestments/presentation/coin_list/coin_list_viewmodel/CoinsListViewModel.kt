package com.example.currencyinvestments.presentation.coin_list.coin_list_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.domain.use_cases.get_coins.GetSortedCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val repo : CoinRepository, private val useCasesGetCoins : GetSortedCoinsUseCase): ViewModel() {

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

    }


    fun getSortedElements() {
        viewModelScope.launch {
            useCasesGetCoins().onStart {
                _state.emit(
                    CoinListState(
                        isLoading = true,
                        coins = emptyList(),
                        error = "",
                        exception = ""
                    )
                )
            }
                .catch {
                    _state.emit(
                        CoinListState(
                            isLoading = false,
                            coins = emptyList(),
                            error = "${it.message}",
                            exception = "${it.message}"
                        )
                    )
                }.collect {
                    _state.emit(
                        CoinListState(
                            isLoading = false,
                            coins = it,
                            error = "",
                            exception = ""
                        )
                    )
                }
        }
    }


    //unused method
    /*  fun getDataAfterDealWithWrapperClass() {
        viewModelScope.launch {
            when (val response = repo.getCoins()) {
                is NetworkResults.Success -> {
                  _state.emit(CoinListState(coins = response.data))
                }
                is NetworkResults.Error -> {
                   _state.emit(CoinListState(error = "${response.code} + ${response.message}"))
                }
                is NetworkResults.Exception -> {
                   _state.emit(CoinListState(error = "\"${response.e.message}\""))
                }

            }
        }

    }*/


  /*  fun getDataAfterDealWithUseCaseClass() {
        viewModelScope.launch {
            useCasesGetCoins.getData().collect { it ->
                when (it) {
                    is NetworkResults.Success -> {
                        it.data
                        _state.emit(CoinListState(coins = it.data))
                    }
                    is NetworkResults.Error -> {
                        it.message
                       _state.emit(CoinListState(error = "${it.code} + ${it.message}"))

                    }
                    is NetworkResults.Exception -> {
                        it.e.message
                       _state.emit(CoinListState(error = "\"${it.e.message}\""))

                    }
                }

            }
        }

    }*/
}







