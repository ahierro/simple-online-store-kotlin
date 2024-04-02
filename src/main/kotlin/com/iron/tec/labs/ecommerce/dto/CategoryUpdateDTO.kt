package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty

class CategoryUpdateDTO {
    private val name: @NotEmpty String? = null
    private val description: @NotEmpty String? = null
    private val deleted: Boolean? = null
}