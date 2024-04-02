package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal
import java.time.LocalDateTime


class PurchaseOrderDTO {
    private val id: String? = null
    private val idUser: String? = null
    private val lines: Set<PurchaseOrderLineDTO>? = null
    private val total: BigDecimal? = null
    private val status: String? = null
    private val createdAt: LocalDateTime? = null

    private val user: UserDTO? = null
}