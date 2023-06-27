package dev.vbogd.spacexdemo.presentation.general

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppProgressBar(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
    )
}