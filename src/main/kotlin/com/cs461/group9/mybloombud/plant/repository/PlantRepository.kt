package com.cs461.group9.mybloombud.plant.repository

import com.cs461.group9.mybloombud.plant.model.Plant
import com.cs461.group9.mybloombud.plant.model.PlantView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlantRepository: JpaRepository<Plant, Int> {
    fun findAllByOrderByNameAsc(): ArrayList<PlantView>

    fun findAllByNameContainingIgnoreCaseOrderByNameAsc(@Param("name") name: String): ArrayList<PlantView>

    fun findPlantByPlantId(plantId: Int): Plant

    fun findFirstByName(name: String): Plant
}