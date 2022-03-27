package com.mmajka.nerbydoctor.ui.navtest

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun pageA(
    viewModel: ViewModelA = hiltViewModel()
) {
    Column {
       Button(onClick = { viewModel.goA() }) {
           Text(text = "Navigate")
       }
    }
}