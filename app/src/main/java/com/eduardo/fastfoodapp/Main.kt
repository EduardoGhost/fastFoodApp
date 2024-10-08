package com.eduardo.fastfoodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.eduardo.fastfoodapp.navegation.NavigationComponent
import com.eduardo.fastfoodapp.ui.theme.FastFoodAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FastFoodAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComponent()


                }
            }
        }
    }
}