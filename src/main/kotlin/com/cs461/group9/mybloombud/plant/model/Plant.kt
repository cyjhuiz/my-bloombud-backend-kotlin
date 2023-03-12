package com.cs461.group9.mybloombud.plant.model

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
class Plant(
    var name: String,
    var imageUrl: String,
    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "lifecycle_info_id") var lifecycleInfo: LifecycleInfo?,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "light_info_id") var lightInfo: LightInfo?,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "temperature_info_id") var temperatureInfo: TemperatureInfo?,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "humidity_info_id") var humidityInfo: HumidityInfo?,
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "water_info_id") var waterInfo: WaterInfo?,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var plantId: Int? = null
) {
    constructor() : this("", "", null, null, null, null, null, null) {

    }
}