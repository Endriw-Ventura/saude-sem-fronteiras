package com.example.saude_sem_fronteiras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import com.example.saude_sem_fronteiras.ui.theme.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaudesemfronteirasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(150.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(80.dp)
                    )
                    Text(stringResource(R.string.app_name_fullcase),
                        color = Color.White)
                }

            }
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Usuário") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    cursorColor = MaterialTheme.colorScheme.tertiary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    cursorColor = MaterialTheme.colorScheme.tertiary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.primary
                )

            ) {
                Text("Entrar", color = MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Cadastrar")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Esqueceu sua senha?")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SaudesemfronteirasTheme {
        Greeting("Android")
    }
}