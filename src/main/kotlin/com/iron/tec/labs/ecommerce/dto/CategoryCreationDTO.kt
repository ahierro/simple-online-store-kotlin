package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.UUID

data class CategoryCreationDTO(
    @field:NotEmpty
    @field:UUID
    val id: String? = null,
    @field:NotEmpty val name: String,
    @field:NotEmpty val description: String,
    val deleted: Boolean? = null
)