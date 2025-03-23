package com.example.saude_sem_fronteiras.ui.components

import android.widget.Spinner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme


@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(150.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Text(
                "Loading",
                color = Color.White
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    SaudesemfronteirasTheme {
        Loading()
    }
}