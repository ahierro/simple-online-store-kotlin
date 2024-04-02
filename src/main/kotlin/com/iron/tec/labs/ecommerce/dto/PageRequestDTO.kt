package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

open class PageRequestDTO {
    protected var page: @NotNull @Min(0) Int? = null
    protected var size: @NotNull @Min(1) Int? = null
}
