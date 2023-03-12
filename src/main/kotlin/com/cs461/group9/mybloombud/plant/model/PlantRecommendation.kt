package com.cs461.group9.mybloombud.plant.model

data class PlantRecommendation(
    val plant: Plant,
    val lightRecommendation: LightRecommendation,
    val temperatureRecommendation: TemperatureRecommendation,
    val humidityRecommendation: HumidityRecommendation
) {
}