package com.example.vk.android.homework.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.vk.android.homework.R
import com.example.vk.android.homework.domain.applist.AppItem
import com.example.vk.android.homework.ui.theme.VKAndroidHomeworkTheme

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit = {}
) {
    val viewModel: AppListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(context.getString(event.messageResId))
                }
            }
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AppListTopBar(
                modifier = Modifier.fillMaxWidth(),
                onLeftIconClick = { viewModel.onRuStoreClick() },
                onRightIconClick = { viewModel.onCategoriesClick() }
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        when (val currentState = state) {
            AppListState.Loading -> {
                Box(Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                    Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            AppListState.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(stringResource(R.string.error_message))
                }
            }

            is AppListState.Content -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                items(
                    items = currentState.appList,
                    key = { it.id }
                ) { app ->
                    AppListItem(
                        app = app,
                        onClick = { onAppClick(app) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppListScreenPreview() {
    VKAndroidHomeworkTheme {
        AppListScreen(
            modifier = Modifier.fillMaxSize(),
            onAppClick = {}
        )
    }
}