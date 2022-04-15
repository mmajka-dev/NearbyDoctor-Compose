package com.mmajka.nerbydoctor.ui.onboarding.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun IntroductionPage(image: Int, header: String, message: String) {
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
