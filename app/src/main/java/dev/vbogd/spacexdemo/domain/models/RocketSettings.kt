package dev.vbogd.spacexdemo.domain.models

data class RocketSettings(
    val mass: MassUnit,
    val height: DistanceUnit,
    val diameters: DistanceUnit,
    val payloadWeight: MassUnit
)

enum class MassUnit(val value: String) {
    Kg("kg"),
    Lb("lb")
}

enum class DistanceUnit(val value: String) {
    Meters("m"),
    Feet("ft")
}