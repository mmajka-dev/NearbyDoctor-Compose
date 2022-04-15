package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.phoneNumber

sealed class PhoneNumberViewEvent{
    data class PhoneNumberChanged(val input: String) : PhoneNumberViewEvent()
    object GetCodeClicked : PhoneNumberViewEvent()
}
