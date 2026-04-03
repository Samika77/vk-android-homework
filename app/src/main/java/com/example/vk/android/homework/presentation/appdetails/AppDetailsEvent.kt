package com.example.vk.android.homework.presentation.appdetails

sealed interface AppDetailsEvent {
    data class ShowSnackbar (
        val message: Int,
    ) : AppDetailsEvent
}