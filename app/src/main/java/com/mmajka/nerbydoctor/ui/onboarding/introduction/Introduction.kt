package com.mmajka.nerbydoctor.ui.onboarding.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.mmajka.nerbydoctor.R
import com.ramcosta.composedestinations.annotation.Destination

private const val PAGE_COUNT = 3

@OptIn(
    ExperimentalPagerApi::class,
    ExperimentalComposeUiApi::class
)
@Destination
@Composable
fun Introduction(
    viewModel: IntroductionViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState()

    ConstraintLayout(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        val (pager, indicator, signIn, signUp, doctorButton) = createRefs()

        HorizontalPager(
            count = PAGE_COUNT,
            state = pagerState,
            modifier = Modifier.constrainAs(pager) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        ) { page ->
            when (page) {
                0 -> IntroductionPage(
                    image = R.drawable.img_appointment,
                    header = stringResource(R.string.introduction_make_appointment),
                    message = stringResource(R.string.introduction_message)
                )
                1 -> IntroductionPage(
                    image = R.drawable.img_find_doctor,
                    header = stringResource(R.string.introduction_find_doctor),
                    message = stringResource(R.string.introduction_message)
                )
                2 -> IntroductionPage(
                    image = R.drawable.img_advice,
                    header = stringResource(R.string.introduction_take_advice),
                    message = stringResource(R.string.introduction_message)
                )
            }
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .constrainAs(indicator) {
                    bottom.linkTo(signIn.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = MaterialTheme.colors.secondary
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(signIn) {
                    bottom.linkTo(signUp.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            onClick = { viewModel.onUiAction(IntroductionViewEvent.SignInClicked) }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = stringResource(R.string.common_sing_in)
            )
        }
        OutlinedButton(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(signUp) {
                    bottom.linkTo(doctorButton.top, margin = 35.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            onClick = { viewModel.onUiAction(IntroductionViewEvent.SingUpClicked) }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = stringResource(R.string.common_create_account)
            )
        }
        Text(
            modifier = Modifier
                .constrainAs(doctorButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(R.string.welcome_are_you_doctor),
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
fun IntroductionPreview() {
    Introduction()
}