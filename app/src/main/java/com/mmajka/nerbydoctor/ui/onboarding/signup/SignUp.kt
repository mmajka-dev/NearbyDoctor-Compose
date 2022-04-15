package com.mmajka.nerbydoctor.ui.onboarding.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.mmajka.nerbydoctor.R
import com.ramcosta.composedestinations.annotation.Destination

private val colors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black,
        focusedBorderColor = MaterialTheme.colors.primary,
        unfocusedBorderColor = Color.Black
    )

@Composable
@Destination
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val state = viewModel.viewState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (image, title, id, password, confirmPassword, email, continueButton) = createRefs()

        Image(
            modifier = Modifier
                .defaultMinSize(minWidth = 290.dp, minHeight = 215.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.img_sign_up),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(R.string.common_create_account),
            style = MaterialTheme.typography.h4
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(id) {
                top.linkTo(title.bottom, margin = 55.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.idInput,
            placeholder = { Text(text = stringResource(R.string.common_your_id)) },
            colors = colors,
            onValueChange = { viewModel.onUiAction(SignUpViewEvent.IdChanged(it)) }
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(password) {
                top.linkTo(id.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.passwordInput,
            placeholder = { Text(text = stringResource(R.string.common_password)) },
            colors = colors,
            onValueChange = { viewModel.onUiAction(SignUpViewEvent.PasswordChanged(it)) }
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(confirmPassword) {
                top.linkTo(password.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.confirmPasswordInput,
            placeholder = { Text(text = stringResource(R.string.common_confirm_password)) },
            colors = colors,
            onValueChange = { viewModel.onUiAction(SignUpViewEvent.ConfirmPasswordChanged(it)) }
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(email) {
                top.linkTo(confirmPassword.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.emailInput,
            placeholder = { Text(text = stringResource(R.string.common_email)) },
            colors = colors,
            onValueChange = { viewModel.onUiAction(SignUpViewEvent.EmailChanged(it)) }
        )
        Button(modifier = Modifier
            .constrainAs(continueButton) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }, onClick = { viewModel.onUiAction(SignUpViewEvent.ContinueClicked) }) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.common_continue)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    SignUp()
}