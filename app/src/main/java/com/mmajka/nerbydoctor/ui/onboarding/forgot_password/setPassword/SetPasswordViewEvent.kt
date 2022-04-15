package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.setPassword

sealed class SetPasswordViewEvent {
    data class PasswordChanged(val input: String) : SetPasswordViewEvent()
    object ContinueClicked : SetPasswordViewEvent()
}
