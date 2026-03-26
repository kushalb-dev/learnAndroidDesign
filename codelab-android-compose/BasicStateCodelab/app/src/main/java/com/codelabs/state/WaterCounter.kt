/*
 * Copyright 2022 The Android Open Source Project
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
package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (count > 0)
            Text(stringResource(R.string.you_ve_had_glasses, count))
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(stringResource(R.string.add_one))
        }
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}