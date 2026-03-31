package com.example.vk.android.homework.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import com.example.vk.android.homework.R
import com.example.vk.android.homework.data.applist.AppListApi
import com.example.vk.android.homework.data.applist.AppListMapper
import com.example.vk.android.homework.data.applist.AppListRepositoryImpl
import com.example.vk.android.homework.domain.applist.AppListRepository

class AppListViewModel : ViewModel() {
    private val appListRepository: AppListRepository = AppListRepositoryImpl(
        mapper = AppListMapper(),
        api = AppListApi(),
    )
    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.value = AppListState.Loading
            runCatching {
                val apps = appListRepository.getAppList()
                AppListState.Content(apps)
            }.fold(
                onSuccess = { _state.value = it },
                onFailure = { _state.value = AppListState.Error }
            )
        }
    }

    fun onRuStoreClick() {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar(R.string.rustore_click))
        }
    }

    fun onCategoriesClick() {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar(R.string.categories_button))
        }
    }
}