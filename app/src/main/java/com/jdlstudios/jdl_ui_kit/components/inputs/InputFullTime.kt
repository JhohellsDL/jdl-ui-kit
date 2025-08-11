package com.jdlstudios.jdl_ui_kit.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputFullTime(
    modifier: Modifier = Modifier ,
    onTimeChange: (String, String, String) -> Unit = { _, _, _ -> }
) {
    var hours by remember { mutableStateOf("") }
    var minutes by remember { mutableStateOf("") }
    var seconds by remember { mutableStateOf("") }

    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        InputTime(
            value = hours,
            onValueChange = { newHours ->
                hours = newHours
                onTimeChange(hours, minutes, seconds)
            },
            textTime = "Hours"
        )

        InputTime(
            value = minutes,
            onValueChange = {newMinutes ->
                minutes = newMinutes
                onTimeChange(hours, minutes, seconds)

            },
            textTime = "Minutes"
        )
        InputTime(
            value = seconds,
            onValueChange = {newSeconds ->
                seconds = newSeconds
                onTimeChange(hours, minutes, seconds)

            },
            textTime = "Seconds"
        )
    }

}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFF121418)
fun InputFullTimePreview() {
    var putina: Triple<String, String, String>
    InputFullTime(
        onTimeChange = { hours, minutes, seconds ->
            putina = Triple(hours, minutes, seconds)
            println("putina: $putina")
        }
    )
}