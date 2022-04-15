package com.mmajka.nerbydoctor.ui.onboarding.biometric

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BiometricViewModel @Inject constructor(): ViewModel() {

    fun onUiAction(action: BiometricViewEvent) {
        when (action) {
            BiometricViewEvent.ContinueClicked -> Unit
            BiometricViewEvent.DismissClicked -> Unit
        }
    }
}