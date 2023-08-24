package com.example.composebuttonsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebuttonsexample.ui.theme.ComposeButtonsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeButtonsExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyButtonExample()
                }
            }
        }
    }
}

@Composable
fun MyButtonExample() {
    // Estado del boton
    // Ponemos rememberSaveable para que el estado se mantenga cuando rotemos el movil
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // Button
        Button(
            onClick = { enabled = false },
            // Desabilitamos el boton una vez pulsado
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false },
            modifier = Modifier.padding(top = 8.dp),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(0)
        ) {
            Text(text = "Hola")
        }

        TextButton(
            onClick = { enabled = false },
            modifier = Modifier.padding(top = 8.dp),
            enabled = enabled,
        ) {
            Text(text = "Hola")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeButtonsExampleTheme {
        MyButtonExample()
    }
}