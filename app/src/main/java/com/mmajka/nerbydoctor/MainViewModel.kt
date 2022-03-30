package com.mmajka.nerbydoctor

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.core.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    val navigationEvent = navigator.navigationEvent
}