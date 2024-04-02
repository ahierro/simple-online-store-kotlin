package com.iron.tec.labs.ecommerce.config

import com.iron.tec.labs.ecommerce.jwt.JwtConfig
import com.nimbusds.jose.JWSAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import javax.crypto.spec.SecretKeySpec

@Configuration
class JwtDecoderConfig @Autowired constructor(val jwtConfig: JwtConfig) {

    @Bean
    fun jwtDecoder(): JwtDecoder {
        return NimbusJwtDecoder.withSecretKey(
            SecretKeySpec(
                jwtConfig.secretKey.toByteArray(),
                JWSAlgorithm.RS256.name
            )
        ).build()
    }
}
