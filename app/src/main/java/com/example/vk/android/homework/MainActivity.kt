package com.example.vk.android.homework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.vk.android.homework.ui.theme.VKAndroidHomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKAndroidHomeworkTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            if (text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Поле не должно быть пустым",
                    Toast.LENGTH_SHORT
                ).show()
                return@Button
            }
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("text", text)
            context.startActivity(intent)
        }) {
            Text("Открыть вторую Activity")
        }

        Button(onClick = {
            if (text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Поле не должно быть пустым",
                    Toast.LENGTH_SHORT
                ).show()
                return@Button
            }
            if (!text.all { it.isDigit() }) {
                Toast.makeText(
                    context,
                    "Введите только цифры",
                    Toast.LENGTH_SHORT
                ).show()
                return@Button
            }
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$text"))
            context.startActivity(intent)
        }) {
            Text("Позвонить другу")
        }

        Button(onClick = {
            if (text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Поле не должно быть пустым",
                    Toast.LENGTH_SHORT
                ).show()
                return@Button
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }
            context.startActivity(Intent.createChooser(intent, "Поделиться через..."))
        }) {
            Text("Поделиться текстом")
        }
    }
}