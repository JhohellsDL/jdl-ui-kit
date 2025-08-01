package com.jdlstudios.jdl_ui_kit.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    textTime: String = "Time"
) {

    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .wrapContentWidth()
        ) {
            TextField(
                modifier = Modifier
                    .widthIn(min = 40.dp, max = 100.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .shadow(
                        elevation = 14.dp,
                        shape = RoundedCornerShape(14.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Red

                    ),
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "00",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        println("Done pressed with value: $value")
                        focusManager.clearFocus()
                    }
                ),
                textStyle = TextStyle(
                    Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    letterSpacing = 0.5.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF5A6473),
                    unfocusedContainerColor = Color(0xFF283039),
                    disabledContainerColor = Color(0xFFCECECE),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .widthIn(min = 40.dp, max = 100.dp)
                    .padding(top = 14.dp),
                text = textTime,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,

                    )
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF283)
fun InputPreview() {
    var text by remember { mutableStateOf("03") }
    Input(
        value = text,
        textTime = "Horas",
        onValueChange = { newValue ->
            text = newValue
        }
    )
}