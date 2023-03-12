package com.cs461.group9.mybloombud

import com.cs461.group9.mybloombud.plant.model.*
import com.cs461.group9.mybloombud.plant.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

@SpringBootApplication
class MyBloombudApplication() {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry
                    .addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<MyBloombudApplication>(*args)
}



