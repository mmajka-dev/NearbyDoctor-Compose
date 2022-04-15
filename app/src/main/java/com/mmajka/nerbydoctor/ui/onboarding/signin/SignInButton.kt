package com.mmajka.nerbydoctor.ui.onboarding.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmajka.nerbydoctor.R
import com.mmajka.nerbydoctor.ui.common.utils.OnClick
import com.mmajka.nerbydoctor.ui.core.utils.Constants

@Composable
fun SignInButton(image: Int, onClick: OnClick) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick() }
            .border(
                1.dp,
                color = Color.Gray,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .defaultMinSize(17.dp, 17.dp),
            painter = painterResource(id = image),
            contentDescription = Constants.NO_DESCRIPTION,
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    SignInButton(image = R.drawable.ic_google, onClick = {})
}
