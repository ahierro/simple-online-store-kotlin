package com.iron.tec.labs.ecommerce.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Null

data class CategoryUpdateDTO (
    @field:Null
    @Schema(hidden = true)
    var id: String? = null,
    @field:NotEmpty val name: String,
    @field:NotEmpty val description: String,
)