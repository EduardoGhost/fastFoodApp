package com.eduardo.fastfoodapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.eduardo.fastfoodapp.ui.theme.Star

@Composable
fun RateComponent(rate: Int) {
    Row {
        repeat(5) { index ->
            val icon = if (index < rate) Icons.Filled.Star else Icons.Outlined.StarBorder
            Icon(imageVector = icon, contentDescription = "Star", tint = Star)
        }
    }
}
