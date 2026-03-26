package com.example.vk.android.homework

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vk.android.homework.presentation.appdetails.AppDetailsScreen
import com.example.vk.android.homework.presentation.applist.AppListScreen
import com.example.vk.android.homework.presentation.applist.appList

object AppDestinations {
    const val APP_LIST_SCREEN = "app_list_screen"
    const val APP_DETAILS_SCREEN = "app_details_screen"
}

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.APP_LIST_SCREEN,
        modifier = modifier
    ) {
        composable(AppDestinations.APP_LIST_SCREEN) {
            AppListScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
                appList = appList,
                onAppClick = { app ->
                    navController.navigate(AppDestinations.APP_DETAILS_SCREEN)
                }
            )
        }

        composable(AppDestinations.APP_DETAILS_SCREEN) {
            AppDetailsScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}