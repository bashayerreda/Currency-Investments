package com.example.currencyinvestments.domain.models

import com.example.currencyinvestments.data.remote.dto.TeamMembers

data class DetailedCoin(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMembers>
)