package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal
import java.time.LocalDateTime


class ProductDTO {
    private val productId: String? = null
    private val productName: String? = null
    private val productDescription: String? = null
    private val stock: Int? = null
    private val price: BigDecimal? = null
    private val smallImageUrl: String? = null
    private val bigImageUrl: String? = null
    private val createdAt: LocalDateTime? = null
    private val category: CategoryDTO? = null
    private val deleted: Boolean? = null
}