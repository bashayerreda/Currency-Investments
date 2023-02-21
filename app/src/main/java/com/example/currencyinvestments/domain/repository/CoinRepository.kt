package com.example.currencyinvestments.domain.repository

import com.example.currencyinvestments.common.Resource
import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinRepository {
  suspend fun getCoins(): Flow<List<CoinDto>>
  suspend fun getCoinDetails(coinId: String): Flow<DetailedCoinDto>
}
