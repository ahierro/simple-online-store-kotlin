package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun create(user: RegisterUserDTO) : UserDetails
    fun confirm(token: String): String

}
