package com.example.vk.android.homework.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = VkBlue,
    primaryContainer = VkBlue.copy(alpha = 0.9f),
    secondary = VkGray,
    surface = VkDark,
    onPrimary = VkWhite,
    onSurface = VkWhite
)

private val LightColorScheme = lightColorScheme(
    primary = VkBlue,
    primaryContainer = VkBlue,
    secondary = VkGray,
    surface = VkWhite,
    onPrimary = VkWhite,
    onSurface = VkDark
)

@Composable
fun VKAndroidHomeworkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}