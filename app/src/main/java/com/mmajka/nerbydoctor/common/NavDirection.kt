package com.mmajka.nerbydoctor.common

import androidx.navigation.NamedNavArgument

data class NavDirection(
    val route: String,
    val args: List<NamedNavArgument>? = emptyList()
)
