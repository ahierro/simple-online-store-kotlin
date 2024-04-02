package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

data class PurchaseOrderCreationDTO (
    val id: @NotNull @UUID String,
    val lines: @NotEmpty MutableSet<PurchaseOrderLineCreationDTO>? = null,
    val total: @NotNull @Positive BigDecimal? = null
)