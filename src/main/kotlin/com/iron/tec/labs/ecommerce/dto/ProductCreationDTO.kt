package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.URL
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

data class ProductCreationDTO(
    @field:NotEmpty @field:UUID val productId: String,
    @field:NotEmpty val productName: String,
    @field:NotEmpty val productDescription: String,
    @field:PositiveOrZero val stock: Int,
    @field:Positive val price: BigDecimal,
    @field:NotEmpty @field:URL val smallImageUrl: String,
    @field:NotEmpty @field:URL val bigImageUrl: String,
    @field:NotEmpty @field:UUID val categoryId: String,
    val deleted: Boolean = false
)