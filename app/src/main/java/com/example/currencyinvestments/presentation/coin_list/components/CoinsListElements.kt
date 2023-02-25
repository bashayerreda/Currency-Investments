package com.example.currencyinvestments.presentation.coin_list.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.currencyinvestments.domain.models.Coin
import okhttp3.internal.wait


@Composable
fun CoinsListElements(coin: Coin, modifier: Modifier = Modifier, onItemClick: (coin:Coin) -> Unit = {}){
    Row(modifier = modifier.fillMaxWidth()
        .clickable {onItemClick(coin) }
        .padding(20.dp),
      horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(text = "${coin.rank}. ${coin.name}  (${coin.symbol}) ",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Text(text = if (coin.isActive) "Active" else "Not Active",
            color = if (coin.isActive) Color.White else Color.Red,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End,
            modifier =  Modifier.align(CenterVertically)



        )

    }

}