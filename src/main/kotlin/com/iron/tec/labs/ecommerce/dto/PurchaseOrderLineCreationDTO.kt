package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.UUID

class PurchaseOrderLineCreationDTO {
    private val idProduct: @NotNull @UUID String? = null
    private val quantity: @NotNull @Positive Int? = null
}
