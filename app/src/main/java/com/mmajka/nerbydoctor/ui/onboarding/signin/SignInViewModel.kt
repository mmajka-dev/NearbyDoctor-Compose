package com.mmajka.nerbydoctor.ui.onboarding.signin

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.BiometricPageDestination
import com.mmajka.nerbydoctor.ui.onboarding.destinations.PasswordPhoneNumberDestination
import com.mmajka.nerbydoctor.ui.onboarding.destinations.SignUpDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignInViewState())
    val viewState: StateFlow<SignInViewState>
        get() = _viewState

    fun onUiAction(action: SignInViewEvent) {
        when (action) {
            SignInViewEvent.FingerprintClicked -> onFingerprintClicked()
            SignInViewEvent.GoogleSignInClicked -> Unit
            SignInViewEvent.FacebookSignInClicked -> Unit
            SignInViewEvent.TwitterSignInClicked -> Unit
            SignInViewEvent.SignUpClicked -> onSignUpClicked()
            SignInViewEvent.ForgotPasswordClicked -> onForgotPasswordClicked()
            is SignInViewEvent.EmailChanged -> onEmailChanged(action.input)
            is SignInViewEvent.PasswordChanged -> onPasswordChanged(action.input)
        }
    }

    private fun onEmailChanged(input: String) {
        _viewState.value = viewState.value.copy(
            email = input
        )
    }

    private fun onPasswordChanged(input: String) {
        _viewState.value = viewState.value.copy(
            password = input
        )
    }

    private fun onForgotPasswordClicked() {
        navigator(NavigationCommand.Navigate(PasswordPhoneNumberDestination))
    }

    private fun onFingerprintClicked() {
        navigator(NavigationCommand.Navigate(BiometricPageDestination))
    }

    private fun onSignUpClicked() {
        navigator(NavigationCommand.Navigate(SignUpDestination))
    }
}