package com.mmajka.nerbydoctor.ui.onboarding.introduction

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor() {

    fun onUiAction(action: IntroductionViewEvent) {
        when (action) {
            IntroductionViewEvent.SignInClicked -> {}
            IntroductionViewEvent.SingUpClicked -> {}
        }
    }
}