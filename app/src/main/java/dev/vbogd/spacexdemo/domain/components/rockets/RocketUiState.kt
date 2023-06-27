package dev.vbogd.spacexdemo.domain.components.rockets

sealed class RocketUiState {

    object Loading: RocketUiState()

    object Error : RocketUiState()

    data class Data(
        val rockets: List<RocketUiModel>
    ) : RocketUiState()
}
