package com.mmajka.nerbydoctor.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.mmajka.nerbydoctor.R
import com.mmajka.nerbydoctor.ui.core.utils.Constants
import com.mmajka.nerbydoctor.ui.onboarding.welcome.WelcomeViewEvent
import com.mmajka.nerbydoctor.ui.onboarding.welcome.WelcomeViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun WelcomePage(
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (title, subtitle, image, button, doctorButton) = createRefs()

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 30.dp)
                },
            text = stringResource(R.string.welcome_header),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(subtitle) {
                    top.linkTo(title.bottom, margin = 10.dp)
                },
            text = stringResource(R.string.welcome_subtitle),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 220.dp)
                .constrainAs(image) {
                    top.linkTo(subtitle.bottom)
                    bottom.linkTo(button.top)
                },
            painter = painterResource(id = R.drawable.img_welcome_doctors),
            contentDescription = Constants.NO_DESCRIPTION
        )

        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(button) {
                    bottom.linkTo(doctorButton.top, margin = 35.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            onClick = { viewModel.onUiAction(WelcomeViewEvent.GetStartedClicked) }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = stringResource(R.string.welcome_get_started)
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


@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    WelcomePage()
}