package com.iron.tec.labs.ecommerce.controllers

import com.iron.tec.labs.ecommerce.dto.AuthenticationResponse
import com.iron.tec.labs.ecommerce.dto.LoginRequest
import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO
import com.iron.tec.labs.ecommerce.services.AuthenticationService
import com.iron.tec.labs.ecommerce.services.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Authentication")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
    private val userService: UserService
) {
    @Operation(
        summary = "Login with user and password and returns JWT token",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "401", description = "Authentication Failure")]
    )
    @PostMapping("/api/login")
    @PreAuthorize("permitAll()")
    fun login(@RequestBody loginRequest: @Valid LoginRequest): AuthenticationResponse? {
        return authenticationService.login(loginRequest)
    }

    @Operation(
        summary = "E-mail confirmation endpoint that activates user",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "404", description = "Not found")]
    )
    @GetMapping("/api/confirm")
    fun confirm(token: String): String {
        return userService.confirm(token)
    }


    @Operation(
        summary = "Creates a user and sends e-mail with confirmation link",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "409", description = "User already exists")]
    )
    @PostMapping("/api/signup")
    @PreAuthorize("permitAll()")
    fun signUp(@Valid @RequestBody registerUserDTO: RegisterUserDTO) {
        authenticationService.signUp(registerUserDTO)
    }
}
