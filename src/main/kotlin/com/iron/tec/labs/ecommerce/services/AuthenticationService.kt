package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.AuthenticationResponse
import com.iron.tec.labs.ecommerce.dto.LoginRequest
import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO

interface AuthenticationService {
    fun login(loginRequest: LoginRequest): AuthenticationResponse?
    fun signUp(signUpRequest: RegisterUserDTO)
}
