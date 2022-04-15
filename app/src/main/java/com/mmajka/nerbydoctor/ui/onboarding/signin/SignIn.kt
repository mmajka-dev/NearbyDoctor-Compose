package com.mmajka.nerbydoctor.ui.onboarding.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

@Composable
@Destination
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel()
) {
    val state = viewModel.viewState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (image,
            email,
            password,
            forgotPassword,
            signIn,
            fingerprint,
            signUp,
            socialSignIn
        ) = createRefs()

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 220.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 40.dp)
                },
            painter = painterResource(id = R.drawable.img_welcome_doctors),
            contentDescription = ""
        )
        OutlinedTextField(
            modifier = Modifier.constrainAs(email) {
                top.linkTo(image.bottom, margin = 55.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.email,
            placeholder = { Text(text = stringResource(id = R.string.common_your_id)) },
            colors = colors,
            onValueChange = { viewModel.onUiAction(SignInViewEvent.EmailChanged(it)) })
        OutlinedTextField(
            modifier = Modifier.constrainAs(password) {
                top.linkTo(email.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            value = state.value.password,
            placeholder = { Text(text = stringResource(id = R.string.common_password)) },
            colors = colors,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { viewModel.onUiAction(SignInViewEvent.PasswordChanged(it)) }
        )

        Text(
            modifier = Modifier
                .constrainAs(forgotPassword) {
                    top.linkTo(password.bottom, margin = 20.dp)
                    end.linkTo(parent.end)
                }
                .clickable { viewModel.onUiAction(SignInViewEvent.ForgotPasswordClicked) },
            text = stringResource(R.string.sign_in_forgot_password),
            style = MaterialTheme.typography.caption,
            color = Color.Black
        )

        Button(modifier = Modifier
            .constrainAs(signIn) {
                top.linkTo(forgotPassword.bottom, margin = 25.dp)
                start.linkTo(parent.start)
                end.linkTo(fingerprint.start, margin = 10.dp)
                width = Dimension.fillToConstraints
            }, onClick = {}) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = R.string.common_sing_in)
            )
        }
        Image(
            modifier = Modifier
                .constrainAs(fingerprint) {
                    top.linkTo(signIn.top)
                    bottom.linkTo(signIn.bottom)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                }
                .clickable { viewModel.onUiAction(SignInViewEvent.FingerprintClicked) },
            painter = painterResource(id = R.drawable.ic_fingerprint),
            contentDescription = Constants.NO_DESCRIPTION
        )

        Text(
            modifier = Modifier
                .clickable { viewModel.onUiAction(SignInViewEvent.SignUpClicked) }
                .constrainAs(signUp) {
                    top.linkTo(signIn.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(R.string.sign_in_create_account),
            color = Color.Black
        )
        Column(
            modifier = Modifier.constrainAs(socialSignIn) {
                bottom.linkTo(parent.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.sign_in_or_sign_with))
            Row(
                modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                SignInButton(image = R.drawable.ic_google) {}
                SignInButton(image = R.drawable.ic_facebook) {}
                SignInButton(image = R.drawable.ic_twitter) {}
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignInPreview() {
    SignIn()
}