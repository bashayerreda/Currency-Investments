package com.example.currencyinvestments.domain.use_cases.get_coins

import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class GetSortedCoinsUseCase @Inject constructor(private val coinRepo : CoinRepository) {
   suspend operator fun invoke(): Flow<List<Coin>> {
        return coinRepo.getCoinsWithFlow().map {
            it.sortedBy {
                it.name
            }
        }
    }

     fun getData() : Flow<NetworkResults<List<Coin>>>{
        return flow {
            emit(coinRepo.getCoins().apply {
            })
        }
    }


}
