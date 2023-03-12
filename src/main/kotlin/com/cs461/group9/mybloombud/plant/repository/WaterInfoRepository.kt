package com.cs461.group9.mybloombud.plant.repository

import com.cs461.group9.mybloombud.plant.model.WaterInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WaterInfoRepository: JpaRepository<WaterInfo, Int> {

}