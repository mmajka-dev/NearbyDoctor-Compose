package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.setPassword

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
fun SetPassword(
    viewModel: SetPasswordViewModel = hiltViewModel()
) {
    val state = viewModel.viewState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (image, title, password, setPassword) = createRefs()

        Image(
            modifier = Modifier
                .defaultMinSize(minHeight = 230.dp, minWidth = 230.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.ic_password),
            contentDescription = Constants.NO_DESCRIPTION
        )

        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(R.string.common_set_new_password),
            style = MaterialTheme.typography.h3
        )

        OutlinedTextField(modifier = Modifier.constrainAs(password) {
            top.linkTo(title.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        },
            value = state.value.passwordInput,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { viewModel.onUiAction(SetPasswordViewEvent.PasswordChanged(it)) },
            placeholder = {
                Text(text = stringResource(id = R.string.common_password))
            },
            colors = colors
        )

        Button(
            modifier = Modifier.constrainAs(setPassword) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            onClick = { viewModel.onUiAction(SetPasswordViewEvent.ContinueClicked) }) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.set_password)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    SetPassword()
}