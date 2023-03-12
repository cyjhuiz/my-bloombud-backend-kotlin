package com.cs461.group9.mybloombud.plant.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@JsonIgnoreProperties("plant")
class WaterInfo(
    var wateringFrequencyInDays: Int,
    var wateringGuideline: String,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plant_id") var plant: Plant?,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var waterInfoId: Int? = null
) {
    constructor() : this(0, "", null, null) {

    }
}