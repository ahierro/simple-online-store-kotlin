package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.URL
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

data class ProductCreationDTO (
    val productId: @NotEmpty @UUID String? = null,
    val productName: @NotEmpty String? = null,
    val productDescription: @NotEmpty String? = null,
    val stock: @PositiveOrZero Int? = null,
    val price: @Positive BigDecimal? = null,
    val smallImageUrl: @NotEmpty @URL String? = null,
    val bigImageUrl: @NotEmpty @URL String? = null,
    val categoryId: @NotEmpty @UUID String? = null,
    val deleted: Boolean? = null
)