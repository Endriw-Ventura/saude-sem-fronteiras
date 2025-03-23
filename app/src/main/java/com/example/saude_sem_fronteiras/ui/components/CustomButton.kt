package com.example.saude_sem_fronteiras.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun CustomButton(text: String, onClickFun: () -> Unit) {
    Button(
        onClick = {
            onClickFun()
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text, color = MaterialTheme.colorScheme.primary)
    }
}
@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    SaudesemfronteirasTheme {
        CustomButton("Teste", {})
    }
}