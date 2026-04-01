package com.example.vk.android.homework.presentation.appdetails

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk.android.homework.R
import com.example.vk.android.homework.data.appdetails.AppDetailsApi
import com.example.vk.android.homework.data.appdetails.AppDetailsMapper
import com.example.vk.android.homework.data.appdetails.AppDetailsRepositoryImpl
import com.example.vk.android.homework.data.CategoryMapper
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel : ViewModel() {

    private val appDetailsRepository: AppDetailsRepository = AppDetailsRepositoryImpl(
        mapper = AppDetailsMapper(categoryMapper = CategoryMapper()),
        api = AppDetailsApi(),
    )
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading
            runCatching {
                val app = appDetailsRepository.get(id = "тут будет id")
                AppDetailsState.Content(app)
            }.fold(
                onSuccess = { _state.value = it },
                onFailure = { _state.value = AppDetailsState.Error }
            )
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

    private suspend fun showUnderDevelopmentSnackbar() {
        _events.send(
            AppDetailsEvent.ShowSnackbar(
                R.string.under_development
            )
        )
    }
}