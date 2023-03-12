package com.cs461.group9.mybloombud.plant.service

import com.cs461.group9.mybloombud.exception.NotFoundException
import com.cs461.group9.mybloombud.plant.model.*
import com.cs461.group9.mybloombud.plant.repository.PlantRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PlantServiceImpl(
    private val plantRepository: PlantRepository,
): PlantService {
    override fun getPlants(name: String?): ArrayList<PlantView> {
        val plants: ArrayList<PlantView>
        System.out.println(name)
        if (name == null) {
            System.out.println("1")
            plants = plantRepository.findAllByOrderByNameAsc()
        } else {
            plants = plantRepository.findAllByNameContainingIgnoreCaseOrderByNameAsc(name)
        }

        return plants
    }

    override fun getPlantByPlantId(plantId: Int): Plant {
        val plant: Plant = plantRepository.findPlantByPlantId(plantId)
        if (plant == null) {
            throw NotFoundException(
                "Plant does not exist."
            )
        }

        return plant
    }

    override fun createPlantAnalysis(plantDetails: PlantDetails): PlantRecommendation {
        val plant: Plant = plantRepository.findFirstByName(plantDetails.name)

        return computePlantRecommendation(
            plant,
            plantDetails
        )
    }

    fun computePlantRecommendation(plant: Plant, plantDetails: PlantDetails): PlantRecommendation  {
        // light computation
        val lightRecommendation: LightRecommendation
        if (plantDetails.light < plant.lightInfo!!.minValue) {
            lightRecommendation = LightRecommendation(
                "Current lighting level is too dark.",
                "Try readjusting the plant to a bright window under direct sunlight or use a grow light instead."
            )
        } else if (plantDetails.light > plant.lightInfo!!.maxValue) {
            lightRecommendation = LightRecommendation(
                "Current lighting level is too bright.",
                "Try placing the plant at a darker window under indirect sunlight, possibly behind another indoor plant or curtain."
            )
        } else {
            lightRecommendation = LightRecommendation(
                "Current lighting level is optimal.",
                "No further adjustment is needed."
            )
        }

        // temperature computation here
        val temperatureRecommendation: TemperatureRecommendation
        if (plantDetails.temperature < plant.temperatureInfo!!.minValue) {
            temperatureRecommendation = TemperatureRecommendation(
                "Current temperature is too cold.",
                "Try keeping the plant outdoors or near an open window."
            )
        } else if (plantDetails.temperature > plant.temperatureInfo!!.maxValue) {
            temperatureRecommendation = TemperatureRecommendation(
                "Current temperature is too hot.",
                "Try placing the plant indoors or in a sheltered location."
            )
        } else {
            temperatureRecommendation = TemperatureRecommendation(
                "Current temperature is optimal.",
                "No further adjustment is needed."
            )
        }

        // humidity computation here
       val humidityRecommendation: HumidityRecommendation
        if (plantDetails.humidity < plant.humidityInfo!!.minValue) {
            humidityRecommendation = HumidityRecommendation(
                "Current humidity level is too low.",
                "Try keeping the humidity level higher by misting, using a humidifier or placing it in more humid area such as the kitchen."
            )
        } else if (plantDetails.humidity > plant.humidityInfo!!.maxValue) {
            humidityRecommendation = HumidityRecommendation(
                "Current humidity level is too high.",
                "Try keeping the humidity level lower by placing the plant in a better ventilated area."
            )
        } else {
            humidityRecommendation = HumidityRecommendation(
                "Current humidity level is optimal.",
                "No further adjustment is needed."
            )
        }


        return PlantRecommendation(
            plant,
            lightRecommendation,
            temperatureRecommendation,
            humidityRecommendation
        )
    }

}