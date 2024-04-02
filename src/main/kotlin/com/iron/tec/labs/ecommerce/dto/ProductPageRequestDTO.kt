package com.iron.tec.labs.ecommerce.dto

import org.hibernate.validator.constraints.UUID
import org.springframework.data.domain.Sort

class ProductPageRequestDTO : PageRequestDTO() {
    private val categoryId: @UUID String? = null
    private val queryString: String? = null
    private val deleted: Boolean? = null
    private val sortByPrice: Sort.Direction? = null
}
