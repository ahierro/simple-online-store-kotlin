package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.URL
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

class ProductCreationDTO {
    private val productId: @NotEmpty @UUID String? = null
    private val productName: @NotEmpty String? = null
    private val productDescription: @NotEmpty String? = null
    private val stock: @PositiveOrZero Int? = null
    private val price: @Positive BigDecimal? = null
    private val smallImageUrl: @NotEmpty @URL String? = null
    private val bigImageUrl: @NotEmpty @URL String? = null
    private val categoryId: @NotEmpty @UUID String? = null
    private val deleted: Boolean? = null
}