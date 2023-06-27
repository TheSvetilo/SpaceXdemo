package dev.vbogd.spacexdemo.presentation.rockets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.vbogd.spacexdemo.domain.components.rockets.RocketUiModel

@Composable
fun RocketContent(
    rocket: RocketUiModel,
    onShowSettingsClick: () -> Unit,
    onShowLaunchesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

    }
}