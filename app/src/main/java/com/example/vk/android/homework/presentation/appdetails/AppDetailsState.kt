package com.example.vk.android.homework.presentation.appdetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val app: App,
    ) : AppDetailsState
}