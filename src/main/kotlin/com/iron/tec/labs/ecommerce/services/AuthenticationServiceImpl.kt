package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.AuthenticationResponse
import com.iron.tec.labs.ecommerce.dto.LoginRequest
import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO
import com.iron.tec.labs.ecommerce.jwt.JWTGeneratorService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthenticationServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val jwtGeneratorService: JWTGeneratorService,
    private val userService: UserService
) : AuthenticationService {
    override fun login(loginRequest: LoginRequest): AuthenticationResponse? {
        val authentication = authenticationManager
            .authenticate(
                UsernamePasswordAuthenticationToken(
                    loginRequest.username,
                    loginRequest.password
                )
            )

        return AuthenticationResponse(
            jwt = jwtGeneratorService
                .generateToken(authentication)
        )
    }

    override fun signUp(signUpRequest: RegisterUserDTO) {
        userService.create(signUpRequest)
    }
}
