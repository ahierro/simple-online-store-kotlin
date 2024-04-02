package com.iron.tec.labs.ecommerce.jwt

import org.springframework.security.core.Authentication

interface JWTGeneratorService {
    fun generateToken(authentication: Authentication?): String?
}
