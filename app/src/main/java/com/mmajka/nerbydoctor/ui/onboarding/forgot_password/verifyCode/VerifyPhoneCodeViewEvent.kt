package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.verifyCode

sealed class VerifyPhoneCodeViewEvent {
    object SetPasswordClicked : VerifyPhoneCodeViewEvent()
    object SendNewCodeClicked : VerifyPhoneCodeViewEvent()
    data class CodeChanged(val input: String) : VerifyPhoneCodeViewEvent()
}
