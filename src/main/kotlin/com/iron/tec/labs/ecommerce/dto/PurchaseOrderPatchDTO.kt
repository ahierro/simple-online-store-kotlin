package com.iron.tec.labs.ecommerce.dto

import com.iron.tec.labs.ecommerce.enums.PurchaseOrderStatus

data class PurchaseOrderPatchDTO(
    val status: PurchaseOrderStatus
)