package com.mmajka.nerbydoctor.ui.core.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() {

    private val _navigationEvent =
        MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 1)
    val navigationEvent = _navigationEvent.asSharedFlow()

    operator fun invoke(command: NavigationCommand) {
        _navigationEvent.tryEmit(command)
    }
}