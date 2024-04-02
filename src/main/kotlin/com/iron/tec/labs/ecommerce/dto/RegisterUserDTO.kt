package com.iron.tec.labs.ecommerce.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length


data class RegisterUserDTO(
    @field:NotEmpty @field:Length(min = 6, max = 50) val username: String,
    @field:NotEmpty @field:Length(min = 6, max = 50) val password: String,
    @field:NotEmpty @field:Length(min = 6, max = 50) @field:Email val email: String,
    @field:NotEmpty @field:Length(min = 3, max = 100) val firstName: String,
    @field:NotEmpty @field:Length(min = 2, max = 100) val lastName: String,
    val isAdmin: Boolean = false
)