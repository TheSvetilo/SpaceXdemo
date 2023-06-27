package dev.vbogd.spacexdemo.domain.components.settings

import com.arkivanov.decompose.ComponentContext
import dev.vbogd.spacexdemo.domain.models.DistanceUnit
import dev.vbogd.spacexdemo.domain.models.MassUnit
import dev.vbogd.spacexdemo.domain.models.RocketSettings
import kotlinx.coroutines.flow.StateFlow

interface SettingsComponent {

    val state: StateFlow<RocketSettings>

    fun onDismissClicked()

    fun onHeightChanged(value: DistanceUnit)
    fun onDiameterChanged(value: DistanceUnit)

    fun onMassChanged(value: MassUnit)
    fun onPayloadWeightChanged(value: MassUnit)

}

class DefaultSettingsComponent(
    component: ComponentContext
) : ComponentContext by component, SettingsComponent {

    override val state: StateFlow<RocketSettings>
        get() = TODO("Not yet implemented")

    override fun onDismissClicked() {
        TODO("Not yet implemented")
    }

    override fun onHeightChanged(value: DistanceUnit) {
        TODO("Not yet implemented")
    }

    override fun onDiameterChanged(value: DistanceUnit) {
        TODO("Not yet implemented")
    }

    override fun onMassChanged(value: MassUnit) {
        TODO("Not yet implemented")
    }

    override fun onPayloadWeightChanged(value: MassUnit) {
        TODO("Not yet implemented")
    }

}