package com.example.u2testdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u2testdemo.ui.theme.U2TestDemoTheme
import androidx.compose.foundation.text.KeyboardOptions as TextKeyboardOptions
import androidx.compose.ui.text.input.KeyboardType.Companion as InputKeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            U2TestDemoTheme {
                AdditionApp()
            }
        }
    }
}

@Composable
fun AdditionApp() {
    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Enter first number") },
            keyboardOptions = TextKeyboardOptions(keyboardType = InputKeyboardType.Number),
            modifier = Modifier.semantics { contentDescription = "First Number Input" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Enter second number") },
            keyboardOptions = TextKeyboardOptions(keyboardType = InputKeyboardType.Number),
            modifier = Modifier.semantics { contentDescription = "Second Number Input" }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val number1 = num1.text.toIntOrNull() ?: 0
                val number2 = num2.text.toIntOrNull() ?: 0
                result = (number1 + number2).toString()
            }, modifier = Modifier.semantics { contentDescription = "Add Button" }
        )
        {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = result,
            onValueChange = { result = it },
            label = { Text("Result") },
            readOnly = true,
            modifier = Modifier.semantics { contentDescription = "Result Output" }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdditionApp()
}