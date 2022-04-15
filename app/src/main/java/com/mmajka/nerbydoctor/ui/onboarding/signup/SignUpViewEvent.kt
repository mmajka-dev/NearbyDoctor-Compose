package com.mmajka.nerbydoctor.ui.onboarding.signup

sealed class SignUpViewEvent {
    data class IdChanged(val input: String) : SignUpViewEvent()
    data class PasswordChanged(val input: String) : SignUpViewEvent()
    data class ConfirmPasswordChanged(val input: String) : SignUpViewEvent()
    data class EmailChanged(val input: String) : SignUpViewEvent()
    object ContinueClicked : SignUpViewEvent()
}
