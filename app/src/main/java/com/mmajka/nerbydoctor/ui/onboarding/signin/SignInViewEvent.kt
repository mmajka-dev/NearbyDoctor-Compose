package com.mmajka.nerbydoctor.ui.onboarding.signin

import com.mmajka.nerbydoctor.ui.models.Credentials

sealed class SignInViewEvent {
    object FingerprintClicked : SignInViewEvent()
    object GoogleSignInClicked: SignInViewEvent()
    object FacebookSignInClicked : SignInViewEvent()
    object TwitterSignInClicked : SignInViewEvent()
    object ForgotPasswordClicked : SignInViewEvent()
    object SignUpClicked : SignInViewEvent()
    data class EmailChanged(val input: String) : SignInViewEvent()
    data class PasswordChanged(val input: String) : SignInViewEvent()
    data class SignInClicked(val credentials: Credentials) : SignInViewEvent()

}
