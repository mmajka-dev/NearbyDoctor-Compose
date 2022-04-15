package com.mmajka.nerbydoctor.ui.onboarding.introduction

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.SignInDestination
import com.mmajka.nerbydoctor.ui.onboarding.destinations.SignUpDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun onUiAction(action: IntroductionViewEvent) {
        when (action) {
            IntroductionViewEvent.SignInClicked -> onSignInClicked()
            IntroductionViewEvent.SingUpClicked -> onSignUpClicked()
        }
    }

    private fun onSignInClicked() {
        navigator(NavigationCommand.Navigate(SignInDestination))
    }

    private fun onSignUpClicked() {
        navigator(NavigationCommand.Navigate(SignUpDestination))
    }
}