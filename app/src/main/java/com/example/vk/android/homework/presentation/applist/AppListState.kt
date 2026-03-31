package com.example.vk.android.homework.presentation.applist

import com.example.vk.android.homework.domain.applist.AppItem

sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(
        val appList: List<AppItem>,
    ) : AppListState
}