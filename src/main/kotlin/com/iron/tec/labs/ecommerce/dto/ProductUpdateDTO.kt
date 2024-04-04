package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.URL
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

data class ProductUpdateDTO (
    @field:NotEmpty val productName: String? = null,
    @field:NotEmpty val productDescription: String? = null,
    @field:PositiveOrZero val stock: Int? = null,
    @field:Positive val price:BigDecimal? = null,
    @field:NotEmpty @field:URL val smallImageUrl: String? = null,
    @field:NotEmpty @field:URL val bigImageUrl: String? = null,
    @field:NotEmpty @field:UUID val categoryId:  String? = null,
    val deleted: Boolean? = null,
)