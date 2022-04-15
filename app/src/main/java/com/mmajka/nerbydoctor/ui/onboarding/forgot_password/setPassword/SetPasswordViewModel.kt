package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.setPassword

import androidx.lifecycle.ViewModel
import com.mmajka.nerbydoctor.ui.core.navigation.NavigationCommand
import com.mmajka.nerbydoctor.ui.core.navigation.Navigator
import com.mmajka.nerbydoctor.ui.onboarding.destinations.SignInDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SetPasswordViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    private val _viewState = MutableStateFlow(SetPasswordViewState())
    val viewState: StateFlow<SetPasswordViewState>
        get() = _viewState

    fun onUiAction(action: SetPasswordViewEvent) {
        when (action) {
            is SetPasswordViewEvent.PasswordChanged -> onPasswordChanged(action.input)
            SetPasswordViewEvent.ContinueClicked -> onContinueClicked()
        }
    }

    private fun onPasswordChanged(input: String) {
        _viewState.value = viewState.value.copy(
            passwordInput = input
        )
    }

    private fun onContinueClicked() {
        navigator(
            NavigationCommand.Navigate(
                destination = SignInDestination,
                popUpTo = SignInDestination.route,
                inclusive = true
            )
        )
    }
}