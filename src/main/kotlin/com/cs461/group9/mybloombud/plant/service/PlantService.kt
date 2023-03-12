package com.cs461.group9.mybloombud.plant.service

import com.cs461.group9.mybloombud.plant.model.Plant
import com.cs461.group9.mybloombud.plant.model.PlantDetails
import com.cs461.group9.mybloombud.plant.model.PlantView
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation

interface PlantService {
    fun getPlants(name: String?): ArrayList<PlantView>

    fun getPlantByPlantId(plantId: Int): Plant

    fun createPlantAnalysis(plantDetails: PlantDetails): PlantRecommendation
}