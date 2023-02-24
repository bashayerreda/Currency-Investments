package com.example.currencyinvestments.presentation.coin_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyinvestments.common.Constants
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.models.DetailedCoin
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.domain.use_cases.get_coins.GetSortedCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsListViewModel @Inject constructor(private val repo : CoinRepository, savedStateHandle : SavedStateHandle): ViewModel() {

    data class CoinInDetails(
        val isLoading: Boolean = false,
        val coin: DetailedCoin? = null,
        val error: String = "",
        val exception: String = ""
    )

    private val _state = MutableStateFlow(CoinInDetails())
    val state = _state.asStateFlow()

    init {
     savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {  coinId ->
              getCoinsDetails(coinId)
     }

    }


    fun getCoinsDetails(coinId: String) {
        viewModelScope.launch {
            repo.getCoinDetailsWithFlow(coinId).onStart {
                _state.emit(
                    CoinInDetails(
                        isLoading = true,
                        coin = null,
                        error = "",
                        exception = ""
                    )
                )
            }
                .catch {
                    _state.emit(
                        CoinInDetails(
                            isLoading = false,
                            coin = null,
                            error = "${it.message}",
                            exception = "${it.message}"
                        )
                    )
                }.collect {
                    _state.emit(
                        CoinInDetails(
                            isLoading = false,
                            coin = it,
                            error = "",
                            exception = ""
                        )
                    )
                }
        }
    }


}