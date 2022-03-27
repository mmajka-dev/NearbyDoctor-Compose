package com.mmajka.nerbydoctor.ui.navtest

import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.mmajka.nerbydoctor.common.NavDirections
import com.mmajka.nerbydoctor.common.Navigator
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelA @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun goA() {
        val arg = listOf(navArgument("args") { type = NavType.StringType } )
        navigator.navigate(NavDirections.b, arg)
    }
}