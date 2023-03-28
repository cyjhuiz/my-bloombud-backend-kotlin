package com.cs461.group9.mybloombud.plant.model

import com.cs461.group9.mybloombud.plant.constant.PlantConstants
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@JsonIgnoreProperties("plant")
class HumidityInfo(
    var description: String,
    var mistingFrequencyInDays: Int,
    var minValue: Double,
    var maxValue: Double,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plant_id") var plant: Plant?,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var humidityInfoId: Int? = null
) {
    constructor() : this("",0, 0.0, 0.0, null, null) {

    }

    var units: String = PlantConstants.PERCENT
}