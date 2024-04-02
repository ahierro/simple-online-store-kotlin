package com.iron.tec.labs.ecommerce.config

import com.iron.tec.labs.ecommerce.jwt.JwtConfig
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.OctetSequenceKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder

@Configuration
class JwtEncoderConfig @Autowired constructor(val jwtConfig: JwtConfig) {

    @Bean
    fun jwtEncoder(): JwtEncoder {

        return NimbusJwtEncoder(
            ImmutableJWKSet(
                JWKSet(
                    OctetSequenceKey.Builder(jwtConfig.secretKey.encodeToByteArray())
                        .keyID(jwtConfig.secretKey)
                        .algorithm(JWSAlgorithm.HS256)
                        .build()
                )
            )
        )
    }
}
