package com.example.currencyinvestments.presentation.coin_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.currencyinvestments.data.remote.dto.TeamMembers


@Composable
fun TeamMembers(team : TeamMembers,modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = team.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = team.position, style = MaterialTheme.typography.body2, fontStyle = FontStyle.Italic)

    }

}