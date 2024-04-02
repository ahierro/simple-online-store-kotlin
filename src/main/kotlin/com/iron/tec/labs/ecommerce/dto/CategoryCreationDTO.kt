package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.UUID

data class CategoryCreationDTO (
    @field:NotEmpty
    @field:UUID
    val id: String? = null,
    val name: @NotEmpty String? = null,
    val description: @NotEmpty String? = null,
    val deleted: Boolean? = null
)