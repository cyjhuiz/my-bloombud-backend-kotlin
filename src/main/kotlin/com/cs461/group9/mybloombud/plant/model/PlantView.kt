package com.cs461.group9.mybloombud.plant.model

interface PlantView {
    val name: String
    val description: String
    val supportingText: String
    val imageUrl: String
    val plantId: Int?
}