package com.mmajka.nerbydoctor.common

import androidx.navigation.NamedNavArgument
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class Navigator @Inject constructor() {

    private val _navigationEvent =
        MutableSharedFlow<NavDirection>(extraBufferCapacity = 1)
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun navigate(direction: String) {
        _navigationEvent.tryEmit(NavDirection(direction))
    }

    fun navigate(direction: String, args: List<NamedNavArgument>){
        _navigationEvent.tryEmit(NavDirection(direction, args))
    }
}