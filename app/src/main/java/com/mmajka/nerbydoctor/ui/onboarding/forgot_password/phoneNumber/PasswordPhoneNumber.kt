package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.phoneNumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.mmajka.nerbydoctor.R
import com.mmajka.nerbydoctor.ui.core.utils.Constants
import com.ramcosta.composedestinations.annotation.Destination

private val colors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black,
        focusedBorderColor = MaterialTheme.colors.primary,
        unfocusedBorderColor = Color.Black
    )

@Destination
@Composable
fun PasswordPhoneNumber(
    viewModel: PhoneNumberViewModel = hiltViewModel()
) {
    val state = viewModel.viewState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (image, title, subtitle, phoneNumber, codeButton) = createRefs()

        Image(
            modifier = Modifier
                .defaultMinSize(215.dp, 195.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.img_forgot_password),
            contentDescription = Constants.NO_DESCRIPTION
        )

        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 50.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            text = stringResource(R.string.phone_number_what_is_my_password),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

        Text(
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            text = stringResource(id = R.string.phone_number_description),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(phoneNumber) {
                top.linkTo(subtitle.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.phoneNumber,
            placeholder = { Text(text = stringResource(R.string.phone_number_your_number)) },
            colors = colors,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = {
                viewModel.onUiAction(PhoneNumberViewEvent.PhoneNumberChanged(it))
            }
        )
        Button(modifier = Modifier.constrainAs(codeButton) {
            bottom.linkTo(parent.bottom, margin = 50.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }, onClick = {
            viewModel.onUiAction(PhoneNumberViewEvent.GetCodeClicked)
        }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.phone_number_get_code)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    PasswordPhoneNumber()
}