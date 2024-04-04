package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.UUID

data class PurchaseOrderLineCreationDTO(
    @field:UUID val idProduct: String,
    @field:Positive val quantity: Int,
)
