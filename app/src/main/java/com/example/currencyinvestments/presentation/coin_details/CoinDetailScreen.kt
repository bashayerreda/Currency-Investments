package com.example.currencyinvestments.presentation.coin_details.components

import android.R.style
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.currencyinvestments.presentation.coin_details.DetailsListViewModel
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun CoinDetailScreen(
    modifier: Modifier = Modifier,
    viewModelState: DetailsListViewModel.CoinInDetails) {
    Box(modifier = Modifier.fillMaxSize()) {
        viewModelState.coin?.let { coinDetailed ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(6.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coinDetailed.rank}.${coinDetailed.name} (${coinDetailed.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coinDetailed.isActive) "Active" else "Not Active",
                            color = if (coinDetailed.isActive) MaterialTheme.colors.primary else Color.Red,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)

                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "${coinDetailed.description}",

                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Tags", style = MaterialTheme.typography.h3)
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coinDetailed.tags.forEach() { tag ->
                            CoinTags(tag = tag)
                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                }
                items(coinDetailed.team) { teamMembers ->
                    TeamMembers(team = teamMembers, modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                        )

                  Divider()
                }
            }

        }

            if (viewModelState.error != null) {
                Text(
                    text = viewModelState.error,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(4.dp)
                )

            }
            if (viewModelState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

        }
    }
