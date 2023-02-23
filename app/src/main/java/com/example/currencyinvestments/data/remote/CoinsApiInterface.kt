package com.example.currencyinvestments.data.remote

import com.example.currencyinvestments.common.Resource
import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.models.DetailedCoin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinsApiInterface {
    @GET("/v1/coins")
    suspend fun getCoins() : Response<List<CoinDto>>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId")coinId : String) : Response<DetailedCoinDto>
}
