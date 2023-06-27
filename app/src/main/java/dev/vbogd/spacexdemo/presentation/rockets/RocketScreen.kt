package dev.vbogd.spacexdemo.presentation.rockets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.vbogd.spacexdemo.domain.components.rockets.RocketUiModel
import dev.vbogd.spacexdemo.domain.components.rockets.RocketUiState
import dev.vbogd.spacexdemo.domain.components.rockets.RocketsComponent
import dev.vbogd.spacexdemo.presentation.general.AppProgressBar
import dev.vbogd.spacexdemo.presentation.general.ErrorMessage

@Composable
fun RocketScreen(component: RocketsComponent) {

    val uiState by component.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val state = uiState) {
            is RocketUiState.Loading -> {
                AppProgressBar()
            }
            is RocketUiState.Error -> {
                ErrorMessage(onClick = component::onTryAgainClicked)
            }
            is RocketUiState.Data -> {

            }
        }
    }
}

@Composable
private fun RocketsContent(
    rockets: List<RocketUiModel>,
    onSettingsClick: () -> Unit,
    onLaunchesClick: (rocketId: String) -> Unit,
    modifier: Modifier = Modifier
) {

}

@Preview(showSystemUi = true)
@Composable
private fun RocketsContentPreview() {
    RocketsContent(listOf(), {}, {})
}