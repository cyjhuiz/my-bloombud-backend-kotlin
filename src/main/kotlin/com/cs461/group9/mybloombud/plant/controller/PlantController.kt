package com.cs461.group9.mybloombud.plant.controller

import com.cs461.group9.mybloombud.plant.model.Plant
import com.cs461.group9.mybloombud.plant.model.PlantDetails
import com.cs461.group9.mybloombud.plant.model.PlantView
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface PlantController {
    fun getPlants(@RequestParam("name") name: String?): ResponseEntity<ArrayList<PlantView>>

    fun getPlantByPlantId(plantId: Int): ResponseEntity<Plant>

    fun createPlantAnalysis(@RequestBody plantDetails: PlantDetails): ResponseEntity<PlantRecommendation>
}