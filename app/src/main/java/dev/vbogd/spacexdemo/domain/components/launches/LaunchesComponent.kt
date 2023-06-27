package dev.vbogd.spacexdemo.domain.components.launches

import com.arkivanov.decompose.ComponentContext

interface LaunchesComponent {
}

class LaunchesComponentImpl(
    componentContext: ComponentContext
) : ComponentContext by componentContext, LaunchesComponent