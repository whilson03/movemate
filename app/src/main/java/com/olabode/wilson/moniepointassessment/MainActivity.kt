package com.olabode.wilson.moniepointassessment

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.olabode.wilson.moniepointassessment.ui.theme.MoveMateTheme
import com.olabode.wilson.moniepointassessment.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.purple_700)
            MoveMateTheme {
                MoveMateApp()
            }
        }
    }
}



