package dev.vbogd.spacexdemo.domain.components.rockets

data class RocketUiModel(
    val id: String,
    val name: String,
    val params: List<RocketParamUiModel>,
    val firstFlight: String,
    val country: String,
    val costPerLaunch: String,
    val firstStage: RocketStageUiModel,
    val secondStage: RocketStageUiModel,
    val flickrImage: String
)

data class RocketParamUiModel(
    val title: String,
    val value: String
)

data class RocketStageUiModel(
    val engines: String,
    val fuelAmountTons: String,
    val burnTimeSec: String
)