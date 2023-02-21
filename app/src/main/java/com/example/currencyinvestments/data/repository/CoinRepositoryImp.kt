package com.example.currencyinvestments.data.repository

import com.example.currencyinvestments.BaseApiHandlingError
import com.example.currencyinvestments.data.mappers.toCoin
import com.example.currencyinvestments.data.retrofit_error_handling.BaseRetrofitErrorClient
import com.example.currencyinvestments.data.remote.CoinsApiInterface
import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import com.example.currencyinvestments.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val coinsApiInterface: CoinsApiInterface,
                                            override var errorData: BaseRetrofitErrorClient
) : CoinRepository , BaseApiHandlingError {
    override suspend fun getCoins(): Flow<List<CoinDto>> {

        return ResponseHandler({
            coinsApiInterface.getCoins()

        }){
            it


        }
    }

    override suspend fun getCoinDetails(coinId: String): Flow<DetailedCoinDto> {
        return ResponseHandler({
                     coinsApiInterface.getCoinDetails(coinId)
        }){
            it
        }
    }

}