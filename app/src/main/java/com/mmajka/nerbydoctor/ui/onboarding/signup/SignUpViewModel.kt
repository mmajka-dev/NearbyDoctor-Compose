package com.mmajka.nerbydoctor.ui.onboarding.signup

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    private val _viewState = MutableStateFlow(SignUpViewState())
    val viewState: StateFlow<SignUpViewState>
        get() = _viewState

    fun onUiAction(action: SignUpViewEvent) {
        when (action) {
            is SignUpViewEvent.IdChanged -> onIdChanged(action.input)
            is SignUpViewEvent.PasswordChanged -> onPasswordChanged(action.input)
            is SignUpViewEvent.ConfirmPasswordChanged -> onConfirmPasswordChanged(action.input)
            is SignUpViewEvent.EmailChanged -> onEmailChanged(action.input)
            SignUpViewEvent.ContinueClicked -> onContinueClicked()
        }
    }

    private fun onIdChanged(input: String) {
        _viewState.value = viewState.value.copy(
            idInput = input
        )
    }

    private fun onPasswordChanged(input: String) {
        _viewState.value = viewState.value.copy(
            passwordInput = input
        )
    }

    private fun onConfirmPasswordChanged(input: String) {
        _viewState.value = viewState.value.copy(
            confirmPasswordInput = input
        )
    }

    private fun onEmailChanged(input: String) {
        _viewState.value = viewState.value.copy(
            emailInput = input
        )
    }

    private fun onContinueClicked() {
        navigator(NavigationCommand.NavigateUp)
    }
}