package com.iron.tec.labs.ecommerce.jwt

import com.iron.tec.labs.ecommerce.db.entities.AppUser
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jose.jws.MacAlgorithm
import org.springframework.security.oauth2.jwt.JwsHeader
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.stream.Collectors

@Service
class JWTGeneratorServiceImpl(private val encoder: JwtEncoder, private val jwtConfig: JwtConfig) : JWTGeneratorService {
    override fun generateToken(authentication: Authentication?): String? {
        val now = Instant.now()
        val scope = authentication!!.authorities.stream()
            .map { grantedAuthority: GrantedAuthority -> grantedAuthority.authority }
            .collect(Collectors.joining(" "))
        val claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(jwtConfig.expiration, ChronoUnit.MILLIS))
            .id(UUID.randomUUID().toString())
            .subject((authentication.principal as AppUser).getSubject())
            .claim(
                "name",
                authentication.name
            )
            .claim("scope", scope)
            .build()

        return encoder
            .encode(JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims))
            .tokenValue
    }
}
