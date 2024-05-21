/*
 * Copyright 2024 Rahmouni Neïl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.rahmouni.neil.counters.core.designsystem.component.tile

import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.rahmouni.neil.counters.core.designsystem.Rn3PaddingValues
import dev.rahmouni.neil.counters.core.designsystem.Rn3PreviewComponentDefault
import dev.rahmouni.neil.counters.core.designsystem.Rn3Theme
import dev.rahmouni.neil.counters.core.designsystem.padding

@Composable
fun Rn3TileHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = Rn3TileHorizontalDividerDefaults.color,
    paddingValues: Rn3PaddingValues = Rn3TileHorizontalDividerDefaults.paddingValues,
) {
    HorizontalDivider(
        modifier.padding(paddingValues),
        color = color,
    )
}

object Rn3TileHorizontalDividerDefaults {
    val paddingValues = Rn3PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    val color: Color @Composable get() = DividerDefaults.color
}


@Rn3PreviewComponentDefault
@Composable
private fun Default() {
    Rn3Theme {
        Surface {
            Rn3TileHorizontalDivider()
        }
    }
}