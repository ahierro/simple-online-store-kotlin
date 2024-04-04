package com.iron.tec.labs.ecommerce.dto

import org.hibernate.validator.constraints.UUID
import org.springframework.data.domain.Sort

data class ProductPageRequestDTO(
    val categoryId: @UUID String? = null,
    val queryString: String? = null,
    val deleted: Boolean? = null,
    val sortByPrice: Sort.Direction? = null,
    override val page: Int,
    override val size: Int,
) : PageRequestDTO(page,size)