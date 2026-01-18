package com.example.medialearning

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AudioScreen(navController: NavHostController) {

    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Audiolibros",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        AudioBookCard(
            title = "A la deriva",
            author = "Horacio Quiroga",
            color = Color(0xFFBBDEFB),
            onPlay = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(context, R.raw.aladeriva)
                mediaPlayer?.start()
            },
            onStop = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        )

        AudioBookCard(
            title = "El abanico",
            author = "Emilia Pardo Bazán",
            color = Color(0xFFC8E6C9),
            onPlay = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(context, R.raw.elabanico)
                mediaPlayer?.start()
            },
            onStop = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        )

        AudioBookCard(
            title = "Memorias de un pavo",
            author = "Gustavo Adolfo Bécquer",
            color = Color(0xFFD1C4E9),
            onPlay = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(context, R.raw.memoriasdeunpavo)
                mediaPlayer?.start()
            },
            onStop = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        )

        AudioBookCard(
            title = "A la sombra de un roble (Cap. 1)",
            author = "Enrique Menéndez y Pelayo",
            color = Color(0xFFFFF9C4),
            onPlay = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(context, R.raw.cap1)
                mediaPlayer?.start()
            },
            onStop = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        )

        AudioBookCard(
            title = "A la sombra de un roble (Cap. 2)",
            author = "Enrique Menéndez y Pelayo",
            color = Color(0xFFFFCCBC),
            onPlay = {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(context, R.raw.cap2)
                mediaPlayer?.start()
            },
            onStop = {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                )
            ) {
                Text("HOMESCREEN")
            }

            Button(
                onClick = {
                    navController.navigate("video")
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                )
            ) {
                Text("VIDEOSCREEN")
            }
        }

    }
}

@Composable
fun AudioBookCard(
    title: String,
    author: String,
    color: Color,
    onPlay: () -> Unit,
    onStop: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = author,
                fontSize = 15.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = onPlay,
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5E35B1)
                    ),
                    modifier = Modifier.height(48.dp)
                ) {
                    Text("▶ Play")
                }

                Button(
                    onClick = onStop,
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD32F2F)
                    ),
                    modifier = Modifier.height(48.dp)
                ) {
                    Text("⏹ Stop")
                }
            }
        }
    }
}

