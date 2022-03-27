package com.mmajka.nerbydoctor.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmajka.nerbydoctor.ui.navtest.pageA
import com.mmajka.nerbydoctor.ui.navtest.pageB
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun NavigationComponent(
    navigator: Navigator
) {
    val navController = rememberNavController()

    LaunchedEffect("navigation") {
        navigator.navigationEvent.onEach {
            navController.navigate(it.route)
        }.launchIn(this)
    }

    NavHost(
        navController = navController,
        startDestination = NavDirections.a
    ) {
        composable(NavDirections.a) { pageA() }
        composable(NavDirections.b) { pageB(test = it.arguments!!.getString("args")!!)}
    }
}