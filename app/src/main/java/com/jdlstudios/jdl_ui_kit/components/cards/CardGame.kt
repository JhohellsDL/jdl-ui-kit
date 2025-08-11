package com.jdlstudios.jdl_ui_kit.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jdlstudios.jdl_ui_kit.R

@Composable
fun CardGame(
    modifier: Modifier = Modifier,
    gameName: String = "Game Name",
    idGame: Int,
    imageGame: Painter,
    isPreference: Boolean = false,
    onClick: (Int) -> Unit = {}
) {
    val shape = RoundedCornerShape(16.dp)

    val preferenceModifier = if (isPreference) {
        Modifier
            .shadow(
                elevation = 8.dp,
                shape = shape,
                clip = false, // Allow glow to extend beyond card bounds
                spotColor = Color(0xFFFFD700), // Gold
                ambientColor = Color(0xFFFFA500)  // Orange
            )
            .border(
                width = 4.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFD700).copy(alpha = 0.7f), // Gold
                        Color(0xFFFFA500).copy(alpha = 0.7f),
                        Color(0xFFB8860B).copy(alpha = 0.7f)  // DarkGoldenrod
                    )
                ),
                shape = shape
            )
    } else {
        Modifier.shadow(
            elevation = 4.dp,
            shape = shape,
            clip = true
        )
    }

    Card(
        shape = shape,
        modifier = modifier
            .width(150.dp)
            .height(150.dp)
            .then(preferenceModifier),
        onClick = {onClick(idGame)},
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp) // Elevation is handled by the shadow modifier
    ) {
        Box {
            Image(
                painter = imageGame,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000000).copy(alpha = 0.4f))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = gameName,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF121418)
fun PreviewCardGame() {
    val imagen = painterResource(id = R.drawable.ic_launcher_foreground)
    CardGame(
        idGame = 132,
        gameName = "Roblox carbrita",
        isPreference = true,
        onClick = {
            println("Game ID clicked: $it")
        },
        imageGame = imagen
    )
}

