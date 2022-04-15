package com.mmajka.nerbydoctor.ui.onboarding.biometric

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun BiometricPage(
    viewModel: BiometricViewModel = hiltViewModel()
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (title, subtitle, image, continueButton, dismissButton) = createRefs()
        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(R.string.biometric_enable),
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            text = stringResource(R.string.biometric_description),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Image(
            modifier = Modifier
                .defaultMinSize(minWidth = 350.dp, minHeight = 265.dp)
                .constrainAs(image) {
                    top.linkTo(subtitle.bottom)
                    bottom.linkTo(continueButton.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(R.drawable.img_fingerprint),
            contentDescription = Constants.NO_DESCRIPTION
        )
        Button(
            modifier = Modifier.constrainAs(continueButton) {
                bottom.linkTo(dismissButton.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            onClick = { viewModel.onUiAction(BiometricViewEvent.ContinueClicked) }) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = R.string.common_continue)
            )
        }
        Text(
            modifier = Modifier
                .clickable { viewModel.onUiAction(BiometricViewEvent.DismissClicked) }
                .constrainAs(dismissButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(R.string.common_not_now),
            color = Color.Black
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    BiometricPage()
}