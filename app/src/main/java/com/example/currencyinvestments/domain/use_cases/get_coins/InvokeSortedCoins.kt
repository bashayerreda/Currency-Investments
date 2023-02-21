package com.example.currencyinvestments.domain.use_cases.get_coins

import com.example.currencyinvestments.data.mappers.toCoin
import com.example.currencyinvestments.data.remote.CoinsApiInterface
import com.example.currencyinvestments.data.remote.dto.CoinDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InvokeSortedCoins @Inject constructor(private val coinsApiInterface: CoinsApiInterface){
    fun invokeCoinsForSorting() : Flow<List<CoinDto>>{
        return flow {
            if (coinsApiInterface.getCoins().isSuccessful){
                coinsApiInterface.getCoins().body()!!.map {
                    it.toCoin()
                }
            }

        }
    }
}