package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

data class LoginRequest(
    @field:NotEmpty @field:Length(min = 6, max = 50) val username: String,
    @field:NotEmpty @field:Length(min = 6, max = 50) val password: String
)
