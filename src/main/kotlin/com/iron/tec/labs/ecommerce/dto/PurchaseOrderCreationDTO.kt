package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

class PurchaseOrderCreationDTO {
    private val id: @NotNull @UUID String? = null

    private val lines: @NotEmpty MutableSet<PurchaseOrderLineCreationDTO>? = null

    private val total: @NotNull @Positive BigDecimal? = null
}