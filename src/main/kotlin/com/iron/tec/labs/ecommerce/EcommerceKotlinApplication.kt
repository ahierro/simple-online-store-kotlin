package com.iron.tec.labs.ecommerce

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@OpenAPIDefinition(info = Info(title = "Ecommerce Kotlin", version = "1.0"))
class EcommerceKotlinApplication

fun main(args: Array<String>) {
	runApplication<EcommerceKotlinApplication>(*args)
}
