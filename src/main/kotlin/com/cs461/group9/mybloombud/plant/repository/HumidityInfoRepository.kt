package com.cs461.group9.mybloombud.plant.repository

import com.cs461.group9.mybloombud.plant.model.HumidityInfo
import com.cs461.group9.mybloombud.plant.model.Plant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface HumidityInfoRepository: JpaRepository<HumidityInfo, Int> {

}