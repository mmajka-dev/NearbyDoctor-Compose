package com.mmajka.nerbydoctor.ui.navtest

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun pageB(test: String) {
    Column {
        Text(text = test)
    }
}