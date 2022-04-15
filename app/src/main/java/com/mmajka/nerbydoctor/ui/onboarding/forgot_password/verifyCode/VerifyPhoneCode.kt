package com.mmajka.nerbydoctor.ui.onboarding.forgot_password.verifyCode

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.mmajka.nerbydoctor.R
import com.ramcosta.composedestinations.annotation.Destination

private val textFieldColors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.textFieldColors(
        textColor = Color.Black,
        backgroundColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Gray,
        focusedIndicatorColor = MaterialTheme.colors.primary
    )

private val textStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 40.sp,
        lineHeight = 28.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

@Destination
@Composable
fun VerifyPhoneCode(
    viewModel: VerifyPhoneCodeViewModel = hiltViewModel(),
    phoneNumber: String
) {
    val state = viewModel.viewState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val (title, subtitle, code, resendCode, verify) = createRefs()

        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 60.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(R.string.verify_code),
            style = MaterialTheme.typography.h1
        )

        Text(
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(id = R.string.verify_code_description, phoneNumber)
        )

        TextField(
            modifier = Modifier.constrainAs(code) {
                top.linkTo(subtitle.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
            },
            value = state.value.code,
            onValueChange = { viewModel.onUiAction(VerifyPhoneCodeViewEvent.CodeChanged(it)) },
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = textFieldColors
        )

        Text(
            modifier = Modifier.constrainAs(resendCode) {
                top.linkTo(code.bottom, margin = 30.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(R.string.verify_code_send_new_code),
            style = MaterialTheme.typography.caption
        )

        Button(
            modifier = Modifier.constrainAs(verify) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            onClick = { viewModel.onUiAction(VerifyPhoneCodeViewEvent.SetPasswordClicked) }) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = R.string.common_set_new_password)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    VerifyPhoneCode(phoneNumber = "530520510")
}