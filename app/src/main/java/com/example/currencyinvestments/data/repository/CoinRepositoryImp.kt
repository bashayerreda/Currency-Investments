package com.example.currencyinvestments.data.repository


import com.example.currencyinvestments.data.remote.CoinsApiInterface
import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.handleApi
import com.example.currencyinvestments.handleResponse
import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.data.mappers.toCoin
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.models.DetailedCoin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val api: CoinsApiInterface) : CoinRepository {

    override suspend fun getCoins(): NetworkResults<List<Coin>> {

        return handleApi {
            Response.success(api.getCoins().body()!!.map { it.toCoin() })
        }
    }

   override suspend fun getCoinDetails(coinId: String): NetworkResults<DetailedCoinDto> {
            TODO("Not yet implemented")
        }


    override suspend fun getCoinsWithFlow(): Flow<List<Coin>> {
        return handleResponse(
            {
                api.getCoins()
            }
        ) {
            it.map {
                it.toCoin()
            }
        }
    }



    override suspend fun getCoinDetailsWithFlow(coinId: String): Flow<DetailedCoinDto> {
        TODO("Not yet implemented")
    }


}