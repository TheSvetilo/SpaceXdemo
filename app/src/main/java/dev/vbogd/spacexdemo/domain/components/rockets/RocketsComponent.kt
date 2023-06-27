package dev.vbogd.spacexdemo.domain.components.rockets

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

interface RocketsComponent {

    val state: StateFlow<RocketUiState>

    fun onLaunchesClicked(rocketId: String)
    fun onSettingsClicked()
    fun onTryAgainClicked()
}

class RocketsComponentImpl(
    componentContext: ComponentContext,
    private val navigateLaunches: (RocketUiModel) -> Unit,
    private val navigateSettings: () -> Unit
) : ComponentContext by componentContext, RocketsComponent {

    override val state: StateFlow<RocketUiState>
        get() = TODO("Not yet implemented")

    override fun onLaunchesClicked(rocketId: String) {
        TODO("Not yet implemented")
    }

    override fun onSettingsClicked() {
        navigateSettings()
    }

    override fun onTryAgainClicked() {
        TODO("Not yet implemented")
    }
}