package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty

data class CategoryUpdateDTO (
    val name: @NotEmpty String,
    val description: @NotEmpty String,
    val deleted: Boolean = false
)