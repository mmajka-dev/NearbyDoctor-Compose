package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.phoneNumber

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.VerifyPhoneCodeDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PhoneNumberViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    private val _viewState = MutableStateFlow(PhoneNumberViewState())
    val viewState: StateFlow<PhoneNumberViewState>
        get() = _viewState

    fun onUiAction(action: PhoneNumberViewEvent) {
        when (action) {
            is PhoneNumberViewEvent.PhoneNumberChanged -> onPhoneNumberChanged(action.input)
            PhoneNumberViewEvent.GetCodeClicked -> onGetCodeClicked()
        }
    }

    private fun onPhoneNumberChanged(input: String) {
        _viewState.value = viewState.value.copy(phoneNumber = input)
    }

    private fun onGetCodeClicked() {
        navigator(NavigationCommand.Navigate(VerifyPhoneCodeDestination("530257621")))
    }
}