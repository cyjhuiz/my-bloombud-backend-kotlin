package com.cs461.group9.mybloombud.plant.controller

import com.cs461.group9.mybloombud.plant.model.Plant
import com.cs461.group9.mybloombud.plant.model.PlantDetails
import com.cs461.group9.mybloombud.plant.model.PlantView
import com.cs461.group9.mybloombud.plant.model.PlantRecommendation
import com.cs461.group9.mybloombud.plant.service.PlantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plant")
class PlantControllerImpl(
    private val plantService: PlantService
): PlantController {
    @GetMapping()
    override fun getPlants(@RequestParam(required = false) name: String?): ResponseEntity<ArrayList<PlantView>> {
        val plants: ArrayList<PlantView> = plantService.getPlants(name)

        return ResponseEntity<ArrayList<PlantView>>(
            plants,
            HttpStatus.OK
        )
    }

    @GetMapping("/{plantId}")
    override fun getPlantByPlantId(@PathVariable plantId: Int): ResponseEntity<Plant> {
        val plant = plantService.getPlantByPlantId(plantId)

        return ResponseEntity<Plant>(
            plant,
            HttpStatus.OK
        )
    }

    @PostMapping("/analysis")
    override fun createPlantAnalysis(plantDetails: PlantDetails): ResponseEntity<PlantRecommendation> {
        val plantRecommendation = plantService.createPlantAnalysis(plantDetails)

        return ResponseEntity<PlantRecommendation>(
            plantRecommendation,
            HttpStatus.OK
        )
    }
}