package com.iron.tec.labs.ecommerce.dto

import java.math.BigDecimal


data class PurchaseOrderLineDTO (
    val idProduct: String? = null,
    val productName: String? = null,
    val stock: Int? = null,
    val price: BigDecimal? = null,
    val smallImageUrl: String? = null,
    val categoryName: String? = null,
    val quantity: Int? = null,
)
