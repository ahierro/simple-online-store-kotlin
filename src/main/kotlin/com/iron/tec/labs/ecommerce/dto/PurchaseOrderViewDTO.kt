package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal
import java.time.LocalDateTime


data class PurchaseOrderViewDTO (
    val id: String? = null,
    val idUser: String? = null,
    val total: BigDecimal? = null,
    val status: String? = null,
    val createdAt: LocalDateTime? = null,
    val username: String? = null,
    val email: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
)