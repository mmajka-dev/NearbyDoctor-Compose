package com.mmajka.nerbydoctor.ui.onboarding.biometric

sealed class BiometricViewEvent {
    object ContinueClicked : BiometricViewEvent()
    object DismissClicked : BiometricViewEvent()
}
