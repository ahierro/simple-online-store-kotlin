package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

open class PageRequestDTO (
    @field:Min(0) open val page: Int,
    @field:Min(1) open val size: Int,
)
