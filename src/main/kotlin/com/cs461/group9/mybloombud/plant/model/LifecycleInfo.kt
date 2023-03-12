package com.cs461.group9.mybloombud.plant.model

import jakarta.persistence.*

@Entity
class LifecycleInfo(
    val title: String,
    val description: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var lifecycleInfoId: Int? = null
) {

    constructor() : this("", "", null) {

    }

}