package com.mmajka.nerbydoctor.core.navigation

import com.ramcosta.composedestinations.spec.Direction

sealed class NavigationCommand {
    data class Navigate(
        val destination: Direction,
        val popUpTo: String? = null,
        val inclusive: Boolean = false
    ) : NavigationCommand()

    data class PopUp(
        val destination: Direction,
        val inclusive: Boolean = false
    ) : NavigationCommand()

    object NavigateUp : NavigationCommand()
}
