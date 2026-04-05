package com.example.vk.android.homework.presentation.appdetails

import android.content.Context
import android.content.Intent
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk.android.homework.R
import com.example.vk.android.homework.domain.appdetails.AppDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val appId = savedStateHandle.get<String>("appId")!!
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
                val app = appDetailsRepository.get(id = appId)
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