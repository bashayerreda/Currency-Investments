package com.example.currencyinvestments.domain.repository

import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.models.DetailedCoin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
  suspend fun getCoins(): NetworkResults<List<Coin>>

  suspend fun getCoinDetails(coinId: String): NetworkResults<DetailedCoinDto>

  suspend fun getCoinsWithFlow(): Flow<List<Coin>>

  suspend fun getCoinDetailsWithFlow(coinId: String): Flow<DetailedCoinDto>
}
