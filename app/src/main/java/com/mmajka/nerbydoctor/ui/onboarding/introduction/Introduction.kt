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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.mmajka.nerbydoctor.R
import com.ramcosta.composedestinations.annotation.Destination

private const val PAGE_COUNT = 3

@OptIn(
    ExperimentalPagerApi::class,
    androidx.compose.ui.ExperimentalComposeUiApi::class
)
@Destination(start = true)
@Composable
fun Introduction() {
    val pagerState = rememberPagerState()
    ConstraintLayout(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        val (pager, indicator, signIn, signUp) = createRefs()

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
                0 -> Page(
                    image = R.drawable.img_appointment,
                    header = stringResource(R.string.make_appointment),
                    message = stringResource(R.string.appointment_message)
                )
                1 -> Page(
                    image = R.drawable.img_find_doctor,
                    header = stringResource(R.string.make_appointment),
                    message = stringResource(R.string.appointment_message)
                )
                2 -> Page(
                    image = R.drawable.img_advice,
                    header = stringResource(R.string.make_appointment),
                    message = stringResource(R.string.appointment_message)
                )
            }
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .constrainAs(indicator) {
                    bottom.linkTo(signIn.top, margin = 40.dp)
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
            onClick = { }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "Sign In"
            )
        }

        OutlinedButton(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(signUp) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            onClick = { }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "Create Account"
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Page(image: Int, header: String = "", message: String = "") {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (img, title, subtitle) = createRefs()

        Image(
            modifier = Modifier
                .size(height = 400.dp, width = 260.dp)
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(img.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = header,
            style = MaterialTheme.typography.h3,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            text = message,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
@Preview(showBackground = true)
fun IntroductionPreview() {
    Introduction()
}