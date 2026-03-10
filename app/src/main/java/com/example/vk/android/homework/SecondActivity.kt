package com.example.vk.android.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vk.android.homework.ui.theme.VKAndroidHomeworkTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKAndroidHomeworkTheme {
                Text(
                    text = "Получен текст: ${intent.getStringExtra("text") ?: "Нет текста"}",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}