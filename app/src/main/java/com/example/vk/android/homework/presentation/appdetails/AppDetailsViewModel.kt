package com.example.vk.android.homework.presentation.appdetails

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk.android.homework.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel : ViewModel() {
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading
                val app = getApp()
                _state.value = AppDetailsState.Content(app)
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }

    fun shareApp(context: Context) {
        (state.value as? AppDetailsState.Content)?.app?.let { app ->
            val shareText = context.getString(
                R.string.share_app_text,
                app.name
            )
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            context.startActivity(
                Intent.createChooser(
                    intent,
                    context.getString(R.string.share_chooser_title)
                )
            )
        }
    }

    fun onInstallClick() {
        viewModelScope.launch { showUnderDevelopmentSnackbar() }
    }

    fun onDeveloperClick() {
        viewModelScope.launch { showUnderDevelopmentSnackbar() }
    }

    // В будущем заменим этот метод на вызов API.
    private fun getApp(): App = App(
        name = "Гильдия Героев: Экшен ММО РПГ",
        developer = "VK Play",
        category = Category.GAME,
        ageRating = 12,
        size = 223.7f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
    )

    private suspend fun showUnderDevelopmentSnackbar() {
        _events.send(
            AppDetailsEvent.ShowSnackbar(
                R.string.under_development
            )
        )
    }
}