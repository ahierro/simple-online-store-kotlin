package com.iron.tec.labs.ecommerce.dto

import java.time.LocalDateTime


data class CategoryDTO(
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val createdAt: LocalDateTime? = null,
    val deleted: Boolean? = null,
)