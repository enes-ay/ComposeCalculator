package com.example.odev5

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
    fun CustomButton(
    text: String,
    fontSize: TextUnit = 26.sp,
    modifier: Modifier = Modifier,
    isFinished: MutableState<Boolean>,
    tf: MutableState<String>
    ) {
        Button(
            onClick = {
                if (isFinished.value) {
                    tf.value = ""
                    tf.value += text
                    isFinished.value = false
                } else {
                    tf.value += text
                }
            },
            modifier = modifier.padding(5.dp)
        ) {
            Text(text = text, fontSize = fontSize)
        }
    }
