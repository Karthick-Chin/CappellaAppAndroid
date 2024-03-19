package com.cappella.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.cappella.login.screen.login.ScreenLogin
import com.cappella.uicomponent.theme.CappellaTheme
import com.cappella.uicomponent.theme.backGroundLight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CappellaTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(backGroundLight)
                }
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenLogin()
                }
            }
        }
    }
}