package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.UUID
import java.math.BigDecimal

data class PurchaseOrderCreationDTO (
    @field:UUID val id: String,
    @field:NotEmpty val lines: MutableSet<PurchaseOrderLineCreationDTO>? = null,
    @field:Positive val total: BigDecimal
)