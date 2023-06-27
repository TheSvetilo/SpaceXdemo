package dev.vbogd.spacexdemo.domain.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import dev.vbogd.spacexdemo.domain.components.launches.LaunchesComponent
import dev.vbogd.spacexdemo.domain.components.launches.LaunchesComponentImpl
import dev.vbogd.spacexdemo.domain.components.rockets.RocketsComponent
import dev.vbogd.spacexdemo.domain.components.rockets.RocketsComponentImpl
import dev.vbogd.spacexdemo.domain.components.settings.DefaultSettingsComponent
import dev.vbogd.spacexdemo.domain.components.settings.SettingsComponent

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>

    val childSlot: Value<ChildSlot<*, SlotChild>>
    fun dismissSlotChild()
    fun onBackClicked()

    sealed class Child {
        class RocketsChild(val component: RocketsComponent) : Child()
        class LaunchesChild(val component: LaunchesComponent) : Child()
    }

    sealed class SlotChild {
        class SettingsSlotChild(val component: SettingsComponent) : SlotChild()
    }
}

class RootComponentImpl(
    componentContext: ComponentContext
) : ComponentContext by componentContext, RootComponent {

    private val screeNavigation = StackNavigation<ScreenConfig>()
    private val slotNavigation = SlotNavigation<SlotConfig>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = screeNavigation,
        handleBackButton = true,
        initialStack = { listOf(ScreenConfig.Rockets) },
        childFactory = ::createChild
    )
    override val childSlot: Value<ChildSlot<*, RootComponent.SlotChild>> = childSlot(
        source = slotNavigation,
        handleBackButton = true,
        childFactory = ::createChild
    )

    override fun dismissSlotChild() {
        slotNavigation.dismiss()
    }

    override fun onBackClicked() {
        screeNavigation.pop()
    }

    private fun createChild(
        config: ScreenConfig,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (config) {
            is ScreenConfig.Rockets -> {
                RootComponent.Child.RocketsChild(
                    RocketsComponentImpl(
                        componentContext = componentContext,
                        navigateLaunches = { rocket ->
                            screeNavigation.push(
                                ScreenConfig.Launches(
                                    rocketId = rocket.id,
                                    rocketName = rocket.name
                                )
                            )
                        },
                        navigateSettings = {
                            slotNavigation.activate(SlotConfig.Settings)
                        }
                    )
                )
            }

            is ScreenConfig.Launches -> {
                RootComponent.Child.LaunchesChild(
                    LaunchesComponentImpl(componentContext)
                )
            }
        }
    }

    private fun createChild(
        config: SlotConfig,
        componentContext: ComponentContext
    ): RootComponent.SlotChild {
        return when (config) {
            is SlotConfig.Settings -> {
                RootComponent.SlotChild.SettingsSlotChild(
                    DefaultSettingsComponent(componentContext)
                )
            }
        }
    }
}

sealed interface ScreenConfig : Parcelable {
    @Parcelize
    object Rockets : ScreenConfig

    @Parcelize
    data class Launches(
        val rocketId: String,
        val rocketName: String
    ) : ScreenConfig
}

sealed interface SlotConfig : Parcelable {
    @Parcelize
    object Settings : SlotConfig
}