package dev.vbogd.spacexdemo.domain.repository

import dev.vbogd.spacexdemo.domain.models.RocketSettings
import kotlinx.coroutines.flow.StateFlow

interface SettingsRepository {

    val currentSettings: RocketSettings

    fun updateSettings(settings: RocketSettings)
    fun observeRocketSettings() : StateFlow<RocketSettings>

}