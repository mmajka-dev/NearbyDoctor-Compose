package com.mmajka.nerbydoctor.core.navigation

import androidx.navigation.NamedNavArgument
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class Navigator @Inject constructor() {

    private val _navigationEvent =
        MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 1)
    val navigationEvent = _navigationEvent.asSharedFlow()

    operator fun invoke(command: NavigationCommand) {
        _navigationEvent.tryEmit(command)
    }
}