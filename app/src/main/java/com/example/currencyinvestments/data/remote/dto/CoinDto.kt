package com.example.currencyinvestments.data.remote.dto

import com.example.currencyinvestments.domain.models.Coin
import com.google.gson.annotations.SerializedName

data class  CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

