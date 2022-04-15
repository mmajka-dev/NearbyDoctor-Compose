package com.mmajka.nerbydoctor.ui.onboarding.welcome

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.IntroductionDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun onUiAction(action: WelcomeViewEvent) {
        when (action) {
            WelcomeViewEvent.GetStartedClicked -> navigateToIntroduction()
        }
    }

    private fun navigateToIntroduction() {
        navigator(NavigationCommand.Navigate(IntroductionDestination))
    }
}