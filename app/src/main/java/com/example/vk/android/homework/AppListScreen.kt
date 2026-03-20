package com.example.vk.android.homework

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk.android.homework.ui.theme.VKAndroidHomeworkTheme

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    appList: List<AppItem>,
    onRuStoreClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onAppClick: (AppItem) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppListTopBar(
                modifier = Modifier.fillMaxWidth(),
                onLeftIconClick = onRuStoreClick,
                onRightIconClick = onCategoriesClick
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
        ) {
            items(
                items = appList,
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

@Preview
@Composable
fun AppListScreenPreview() {
    VKAndroidHomeworkTheme {
        AppListScreen(
            modifier = Modifier.fillMaxSize(),
            appList = appList,
            onRuStoreClick = {},
            onCategoriesClick = {},
            onAppClick = {}
        )
    }
}