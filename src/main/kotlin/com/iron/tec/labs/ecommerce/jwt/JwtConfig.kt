package com.iron.tec.labs.ecommerce.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class JwtConfig(
    @Value("\${jwt.secret.key}") val secretKey: String,
    @Value("\${jwt.secret.expiration.in.milliseconds}") val expiration: Long
)
