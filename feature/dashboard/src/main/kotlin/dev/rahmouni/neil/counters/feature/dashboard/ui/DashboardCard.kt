package dev.rahmouni.neil.counters.feature.dashboard.ui

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.rahmouni.neil.counters.core.data.model.CounterData
import dev.rahmouni.neil.counters.core.designsystem.component.Rn3IconButton
import dev.rahmouni.neil.counters.core.designsystem.component.getHaptic

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CounterData.DashboardCard(modifier: Modifier = Modifier, onIncrement: (String) -> Unit) {
    val haptics = getHaptic()
    val context = LocalContext.current

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.combinedClickable(
                onClick = {
                    haptics.click()

                    Toast.makeText(context, currentValue.toString(), Toast.LENGTH_SHORT).show()
                    //TODO("Not implemented - add counter page")
                },
                onLongClick = {
                    haptics.longPress()

                    //TODO("Not implemented - add long clicks")
                },
            ),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(8.dp),
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {

                AnimatedContent(
                    targetState = currentValue,
                    transitionSpec = {
                        if (targetState > initialState) {
                            (slideInVertically { height -> (height / 1.5f).toInt() } + fadeIn()).togetherWith(
                                slideOutVertically { height -> -(height / 1.5f).toInt() } + fadeOut(),
                            )
                        } else {
                            (slideInVertically { height -> -(height / 1.5f).toInt() } + fadeIn()).togetherWith(
                                slideOutVertically { height -> (height / 1.5f).toInt() } + fadeOut(),
                            )
                        }.using(SizeTransform(clip = false))
                    },
                    label = "value count animation",
                )
                { targetValue ->
                    Text(
                        targetValue.toString(),
                        Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center,
                    )
                }

                Rn3IconButton(
                    icon = Icons.Outlined.Add,
                    contentDescription = "Increment by one",
                ) {
                    onIncrement(uid)
                }
            }
        }
    }
}