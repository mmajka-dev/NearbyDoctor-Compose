package com.mmajka.nerbydoctor.ui.onboarding.welcome

sealed class WelcomeViewEvent {
    object GetStartedClicked : WelcomeViewEvent()
}
