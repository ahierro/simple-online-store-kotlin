package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

data class LoginRequest(
    val username: @NotEmpty @Length(min = 6, max = 50) String,
    val password: @NotEmpty @Length(min = 6, max = 50) String
)
