package com.example.vk.android.homework.presentation.applist

sealed interface AppListEvent {
    data class ShowSnackbar(
        val messageResId: Int
    ) : AppListEvent
}