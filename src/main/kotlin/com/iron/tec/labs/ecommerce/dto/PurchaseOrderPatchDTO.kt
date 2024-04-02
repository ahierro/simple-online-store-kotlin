package com.iron.tec.labs.ecommerce.dto

import com.iron.tec.labs.ecommerce.enums.PurchaseOrderStatus
import jakarta.validation.constraints.NotNull

class PurchaseOrderPatchDTO {
    private val status: @NotNull PurchaseOrderStatus? = null
}