package com.mmajka.nerbydoctor.ui.onboarding.introduction

sealed class IntroductionViewEvent {
    object SignInClicked : IntroductionViewEvent()
    object SingUpClicked : IntroductionViewEvent()
}
