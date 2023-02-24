package com.example.currencyinvestments.data.mappers

import com.example.currencyinvestments.data.remote.dto.CoinDto
import com.example.currencyinvestments.data.remote.dto.DetailedCoinDto
import com.example.currencyinvestments.domain.models.Coin
import com.example.currencyinvestments.domain.models.DetailedCoin

//mapper
fun DetailedCoinDto.toDetailsCoin() : DetailedCoin {
    return DetailedCoin(coinId = id,name=name,description=description,symbol=symbol,rank=rank, isActive = is_active, tags = tags.map { it.name }, team = team)
}
//mapper data from dto to model

fun CoinDto.toCoin(): Coin {
    return Coin(id= id,isActive = isActive, name = name ,rank=rank,symbol=symbol)
}


