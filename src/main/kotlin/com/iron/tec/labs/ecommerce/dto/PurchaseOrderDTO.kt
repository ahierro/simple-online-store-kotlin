package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal
import java.time.LocalDateTime


data class PurchaseOrderDTO(
    val id: String? = null,
    val idUser: String? = null,
    val lines: Set<PurchaseOrderLineDTO>? = null,
    val total: BigDecimal? = null,
    val status: String? = null,
    val createdAt: LocalDateTime? = null,
    val user: UserDTO? = null,
)