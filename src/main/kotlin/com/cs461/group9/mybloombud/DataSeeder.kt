package com.cs461.group9.mybloombud

import com.cs461.group9.mybloombud.plant.model.*
import com.cs461.group9.mybloombud.plant.repository.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

@Configuration
@Transactional
class DataSeeder(
    @Value("\${spring.datasource.url}") val dbUrl: String,
    @Value("\${spring.datasource.username}")val dbUsername: String,
    @Value("\${spring.datasource.password}") val dbPassword: String
) {
    @Bean
    fun insertTestData(
        plantRepository: PlantRepository,
        lifecycleInfoRepository: LifecycleInfoRepository,
        lightInfoRepository: LightInfoRepository,
        temperatureInfoRepository: TemperatureInfoRepository,
        humidityInfoRepository: HumidityInfoRepository,
        waterInfoRepository: WaterInfoRepository
    ): CommandLineRunner {
        return CommandLineRunner { args ->
            val connection: Connection
            val connectionProps: Properties = Properties()
            connectionProps.put("user", dbUsername)
            connectionProps.put("password", dbPassword)

            connection = DriverManager.getConnection(dbUrl, connectionProps)

            try {

                //test if database "remittance" exist
                val preparedStatement = connection.prepareStatement("SELECT * FROM mybloombud.plant")
                val resultSet = preparedStatement.executeQuery()
                //check if there is data in the user table
                // if there is no data in remittance database, seed test data into database
                val dbHasData: Boolean = resultSet.next()
                if (dbHasData) {
                    println("Test data already exists")
                } else {
                    println("Test data does not exist. Creating test data")
                    // insert test data

                    // insert life cycle data for all plants
                    var annualLifecycleInfo = LifecycleInfo(
                        "Annual",
                        "This is an annual plant, which typically lives for 1 year"
                    )
                    annualLifecycleInfo = lifecycleInfoRepository.save(annualLifecycleInfo)


                    var perennialLifecycleInfo = LifecycleInfo(
                        "Perennial",
                        "This is a perennial plant, which typically lives for more than 2 years"
                    )
                    perennialLifecycleInfo = lifecycleInfoRepository.save(perennialLifecycleInfo)

                    // insert rose
                    var rose = Plant(
                        "Rose",
                        "Their stems are usually prickly and their glossy, green leaves have toothed edges.",
                        "Many roses are fragrant, and some produce berry-like fruits called hips.",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/rose.jpg",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/redrose.sfb",
                        perennialLifecycleInfo,
                        null,
                        null,
                        null,
                        null
                    )
                    rose = plantRepository.save(rose)

                    var roseLightInfo = LightInfo(
                        "Full sun",
                        "Part sun, part shade",
                        30000.0,
                        100000.0,
                        rose
                    )
                    rose.lightInfo = roseLightInfo
                    roseLightInfo = lightInfoRepository.save(roseLightInfo)

                    var roseTemperatureInfo = TemperatureInfo(
                        28.0,
                        32.0,
                        rose,
                    )
                    rose.temperatureInfo = roseTemperatureInfo
                    roseTemperatureInfo = temperatureInfoRepository.save(roseTemperatureInfo)

                    var roseHumidityInfo = HumidityInfo(
                        "Normal humidity need",
                        6,
                        60.0,
                        70.0,
                        rose
                    )
                    rose.humidityInfo = roseHumidityInfo
                    roseHumidityInfo = humidityInfoRepository.save(roseHumidityInfo)

                    var roseWaterInfo = WaterInfo(
                        9,
                        "Top layer should by dry",
                        rose,
                    )
                    rose.waterInfo = roseWaterInfo
                    roseWaterInfo = waterInfoRepository.save(roseWaterInfo)

                    rose = plantRepository.save(rose)

                    // insert dandelion
                    var dandelion = Plant(
                        "Dandelion",
                        "Bright yellow discs of tightly packed florets above a rosette of jaggedly toothed leaves are followed by fluffy white seed heads.",
                        "The name is derived from it's jaggedly toothed leaves were thought to resemble the teeth in a lion’s jaw.",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/dandelion.jpg",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/dandelion.sfb",
                        perennialLifecycleInfo,
                        null,
                        null,
                        null,
                        null

                    )
                    dandelion = plantRepository.save(dandelion)

                    var dandelionLightInfo = LightInfo(
                        "Full sun",
                        "Part sun, part shade",
                        30000.0,
                        100000.0,
                        dandelion
                    )
                    dandelion.lightInfo = dandelionLightInfo
                    dandelionLightInfo = lightInfoRepository.save(dandelionLightInfo)

                    var dandelionTemperatureInfo = TemperatureInfo(
                        10.0,
                        21.0,
                        dandelion
                    )
                    dandelion.temperatureInfo = dandelionTemperatureInfo
                    dandelionTemperatureInfo = temperatureInfoRepository.save(dandelionTemperatureInfo)

                    var dandelionHumidityInfo = HumidityInfo(
                        "Normal humidity need",
                        6,
                        30.0,
                        50.0,
                        dandelion
                    )
                    dandelion.humidityInfo = dandelionHumidityInfo
                    dandelionHumidityInfo = humidityInfoRepository.save(dandelionHumidityInfo)

                    var dandelionWaterInfo = WaterInfo(
                        9,
                        "Top layer should by dry",
                        dandelion
                    )
                    dandelion.waterInfo = dandelionWaterInfo
                    dandelionWaterInfo = waterInfoRepository.save(dandelionWaterInfo)

                    dandelion = plantRepository.save(dandelion)

                    // insert daisy
                    var daisy = Plant(
                        "Daisy",
                        "Each flower has a rosette of small, thin white petals surrounding a bright yellow centre.",
                        "It is a common wild flower found growing in our garden lawns.",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/daisy.jpg",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/daisy.sfb",
                        perennialLifecycleInfo,
                        null,
                        null,
                        null,
                        null
                    )
                    daisy = plantRepository.save(daisy)

                    var daisyLightInfo = LightInfo(
                        "Part sun, part shade",
                        "Full sun",
                        10000.0,
                        25000.0,
                        daisy
                    )
                    daisy.lightInfo = daisyLightInfo
                    daisyLightInfo = lightInfoRepository.save(daisyLightInfo)

                    var daisyTemperatureInfo = TemperatureInfo(
                        21.0,
                        24.0,
                        daisy
                    )
                    daisy.temperatureInfo = daisyTemperatureInfo
                    daisyTemperatureInfo = temperatureInfoRepository.save(daisyTemperatureInfo)

                    var daisyHumidityInfo = HumidityInfo(
                        "Normal humidity need",
                        2,
                        60.0,
                        65.0,
                        daisy
                    )
                    daisy.humidityInfo = daisyHumidityInfo
                    daisyHumidityInfo = humidityInfoRepository.save(daisyHumidityInfo)

                    var daisyWaterInfo = WaterInfo(
                        2,
                        "Keep soil moist",
                        daisy
                    )
                    daisy.waterInfo = daisyWaterInfo
                    daisyWaterInfo = waterInfoRepository.save(daisyWaterInfo)

                    daisy = plantRepository.save(daisy)

                    // insert sunflower
                    var sunflower = Plant(
                        "Sunflower",
                        "Each flower has a green erect stem covered in coarse hairs, growing on average around 2m tall.",
                        "Many roses are fragrant, and some produce berry-like fruits called hips.",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/sunflower.jpg",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/sunflower.jpg",
                        annualLifecycleInfo,
                        null,
                        null,
                        null,
                        null

                    )
                    sunflower = plantRepository.save(sunflower)

                    var sunflowerLightInfo = LightInfo(
                        "Full sun",
                        null,
                        30000.0,
                        100000.0,
                        sunflower
                    )
                    sunflower.lightInfo = sunflowerLightInfo
                    sunflowerLightInfo = lightInfoRepository.save(sunflowerLightInfo)

                    var sunflowerTemperatureInfo = TemperatureInfo(
                        18.0,
                        25.0,
                        sunflower
                    )
                    sunflower.temperatureInfo = sunflowerTemperatureInfo
                    sunflowerTemperatureInfo = temperatureInfoRepository.save(sunflowerTemperatureInfo)

                    var sunflowerHumidityInfo = HumidityInfo(
                        "Normal humidity need",
                        6,
                        8.0,
                        10.0,
                        sunflower
                    )
                    sunflower.humidityInfo = sunflowerHumidityInfo
                    sunflowerHumidityInfo = humidityInfoRepository.save(sunflowerHumidityInfo)

                    var sunflowerWaterInfo = WaterInfo(
                        4,
                        "Keep soil moist",
                        sunflower
                    )
                    sunflower.waterInfo = sunflowerWaterInfo
                    sunflowerWaterInfo = waterInfoRepository.save(sunflowerWaterInfo)

                    sunflower = plantRepository.save(sunflower)

                    // insert tulip
                    var tulip = Plant(
                        "Tulip",
                        "A tulip plant has two or three thick, bluish green leaves. These are attached at the bottom of the stem. In most types of tulip each stem grows a single flower.",
                        "Plants that bloom in early spring. The flowers are cup-shaped and very colorful.",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/image/tulip.jpg",
                        "https://elasticbeanstalk-ap-southeast-2-518367695775.s3.ap-southeast-2.amazonaws.com/ar-model/tulip.sfb",
                        perennialLifecycleInfo,
                        null,
                        null,
                        null,
                        null

                    )
                    tulip = plantRepository.save(tulip)

                    var tulipLightInfo = LightInfo(
                        "Full sun",
                        "Part sun, part shade",
                        30000.0,
                        100000.0,
                        tulip
                    )
                    tulip.lightInfo = tulipLightInfo
                    tulipLightInfo = lightInfoRepository.save(tulipLightInfo)

                    var tulipTemperatureInfo = TemperatureInfo(
                        5.0,
                        30.0,
                        tulip
                    )
                    tulip.temperatureInfo = tulipTemperatureInfo
                    tulipTemperatureInfo = temperatureInfoRepository.save(tulipTemperatureInfo)

                    var tulipHumidityInfo = HumidityInfo(
                        "Normal humidity need",
                        6,
                        50.0,
                        70.0,
                        tulip
                    )
                    tulip.humidityInfo = tulipHumidityInfo
                    tulipHumidityInfo = humidityInfoRepository.save(tulipHumidityInfo)

                    var tulipWaterInfo = WaterInfo(
                        9,
                        "Top layer should be dry",
                        tulip
                    )
                    tulip.waterInfo = tulipWaterInfo
                    tulipWaterInfo = waterInfoRepository.save(tulipWaterInfo)

                    tulip = plantRepository.save(tulip)

                    println("Test data has finished creating")

                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

}