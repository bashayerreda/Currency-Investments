package com.example.currencyinvestments.domain.use_cases.get_coins

import com.example.currencyinvestments.common.NetworkResults
import com.example.currencyinvestments.data.mappers.toCoin
import com.example.currencyinvestments.data.remote.CoinsApiInterface
import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.repository.CoinRepository
import com.example.currencyinvestments.handleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.joinAll
import retrofit2.HttpException
import java.io.IOException
import java.util.Collections.sort
import javax.inject.Inject

class InvokeSortedCoins @Inject constructor(private val coinRepo : CoinRepository) {
    suspend fun sortCoins(): Flow<List<Coin>> {
        return  coinRepo.getCoinsWithFlow().map { it.sortedBy { it.id } }
    }
}