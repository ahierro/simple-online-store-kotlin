package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDTO (
    val productId: String? = null,
    val productName: String? = null,
    val productDescription: String? = null,
    val stock: Int? = null,
    val price: BigDecimal? = null,
    val smallImageUrl: String? = null,
    val bigImageUrl: String? = null,
    val createdAt: LocalDateTime? = null,
    val category: CategoryDTO? = null,
    val deleted: Boolean = true,
)