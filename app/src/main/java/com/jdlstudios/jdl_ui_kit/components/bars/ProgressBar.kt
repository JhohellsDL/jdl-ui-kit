package com.jdlstudios.jdl_ui_kit.components.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProgressBar(modifier: Modifier = Modifier, progress: Float = 0f) {
    val textProgress = "${progress * 100}%"
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .height(16.dp),
            color = Color(0xFF9CAAB9),
            trackColor = Color(0xFF283039),
            gapSize = 0.dp,
        )
        Text(
            text = textProgress,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 15.dp),
            style = TextStyle(
                color = Color(0xFF9CAAB9),
                fontSize = 14.sp,
            )
        )
    }

}

@Composable
@Preview(showBackground = true)
fun ProgressBarPreview() {
    Column {
        ProgressBar(
            progress = 0.8f, modifier = Modifier
                .background(
                    Color(0xFF121418)
                )
                .padding(top = 8.dp, bottom = 8.dp)
        )
        ProgressBar(
            progress = 0.1f, modifier = Modifier
                .background(Color(0xFF121418))
                .padding(top = 8.dp, bottom = 8.dp)
        )
        ProgressBar(
            progress = 0.8f, modifier = Modifier
                .background(Color(0xFF121418))
                .padding(top = 8.dp, bottom = 8.dp)
        )
    }

}

