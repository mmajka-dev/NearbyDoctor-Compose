package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.verifyCode

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.SetPasswordDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class VerifyPhoneCodeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    private val _viewState = MutableStateFlow(VerifyPhoneCodeViewState())
    val viewState: StateFlow<VerifyPhoneCodeViewState>
        get() = _viewState

    fun onUiAction(action: VerifyPhoneCodeViewEvent) {
        when (action) {
            VerifyPhoneCodeViewEvent.SetPasswordClicked -> onSetPasswordClicked()
            VerifyPhoneCodeViewEvent.SendNewCodeClicked -> onSendNewCodeClicked()
            is VerifyPhoneCodeViewEvent.CodeChanged -> onCodeChanged(action.input)
        }
    }

    private fun onCodeChanged(code: String) {
        _viewState.value = viewState.value.copy(
            code = code
        )
    }

    private fun onSendNewCodeClicked() {

    }

    private fun onSetPasswordClicked() {
        navigator(NavigationCommand.Navigate(SetPasswordDestination))
    }
}