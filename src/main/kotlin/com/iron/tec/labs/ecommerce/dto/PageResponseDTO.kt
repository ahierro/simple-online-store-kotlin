package com.iron.tec.labs.ecommerce.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

@JsonIgnoreProperties("pageable", "last", "size", "sort", "first", "numberOfElements", "empty")
open class PageResponseDTO<T> : PageImpl<T> {
    constructor(content: List<T>, pageable: Pageable, total: Long) : super(
        content, pageable, total
    )

    constructor(content: List<T>?) : super(content!!)
}
