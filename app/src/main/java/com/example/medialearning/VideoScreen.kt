package com.example.medialearning

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun VideoScreen(navController: NavHostController) {

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
            text = "Vídeos Educativos",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        VideoCard(
            title = "Higiene Personal",
            description = "Higiene básica para ayudarte a ti y a todos.",
            imageUrl = "https://centromedicoabc.com/wp-content/uploads/2023/08/shutterstock_1677181513.webp",
            videoUrl = "https://upload.wikimedia.org/wikipedia/commons/transcoded/9/9b/Acabe_con_los_microbios._%C2%A1L%C3%A1vese_las_manos%21.webm/Acabe_con_los_microbios._%C2%A1L%C3%A1vese_las_manos%21.webm.480p.vp9.webm",
            color = Color(0xFFBBDEFB),
            navController = navController
        )

        VideoCard(
            title = "Arte",
            description = "Museo de Antropología y Arqueología.",
            imageUrl = "https://oca-gallery.com/wp-content/uploads/2021/12/museo-nacional-de-arqueologia-antropologia-e-historia-del-peru-scaled.jpg",
            videoUrl = "https://upload.wikimedia.org/wikipedia/commons/transcoded/3/31/En_el_museo_de_Antropolog%C3%ADa_y_Arqueolog%C3%ADa.webm/En_el_museo_de_Antropolog%C3%ADa_y_Arqueolog%C3%ADa.webm.480p.vp9.webm",
            color = Color(0xFFC8E6C9),
            navController = navController
        )

        VideoCard(
            title = "Aprender Matemáticas",
            description = "Trigonometría",
            imageUrl = "https://concepto.de/wp-content/uploads/2015/02/trigonometria-e1550786284817.jpg",
            videoUrl = "https://upload.wikimedia.org/wikipedia/commons/transcoded/d/dc/Planteo_Trigonometr%C3%ADa_1.webm/Planteo_Trigonometr%C3%ADa_1.webm.360p.webm",
            color = Color(0xFFFFF9C4),
            navController = navController
        )

        VideoCard(
            title = "Geografía",
            description = "Conociendo la China urbana",
            imageUrl = "https://www.investorsglobe.com/wp-content/uploads/2017/10/china.jpg",
            videoUrl = "https://upload.wikimedia.org/wikipedia/commons/transcoded/e/e2/Me_VOLVI%C3%93_LOCO_esta_CIUDAD_CHINA_-_Xiamen.webm/Me_VOLVI%C3%93_LOCO_esta_CIUDAD_CHINA_-_Xiamen.webm.1080p.vp9.webm",
            color = Color(0xFFC4FFD3),
            navController = navController
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("HOMESCREEN")
            }

            Button(
                onClick = { navController.navigate("audio") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("AUDIOSCREEN")
            }
        }
    }
}

@Composable
fun VideoCard(
    title: String,
    description: String,
    imageUrl: String,
    videoUrl: String,
    color: Color,
    navController: NavHostController
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(description, fontSize = 14.sp, color = Color.DarkGray)

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        val encodedUrl = Uri.encode(videoUrl)
                        navController.navigate("video_player/$encodedUrl")
                    },
                    shape = RoundedCornerShape(50)
                ) {
                    Text("▶ Ver video")
                }
            }
        }
    }
}
