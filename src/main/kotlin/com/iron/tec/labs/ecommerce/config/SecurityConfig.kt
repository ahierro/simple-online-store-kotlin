package com.iron.tec.labs.ecommerce.config

import com.iron.tec.labs.ecommerce.constants.Constants
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors(Customizer.withDefaults())
            .csrf { csrfConfigurer: CsrfConfigurer<HttpSecurity> -> csrfConfigurer.disable() }
            .authorizeHttpRequests { authorizeHttpRequestsCustomizer ->
                authorizeHttpRequestsCustomizer
                    .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/signup").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/confirm").permitAll()
                    .requestMatchers(HttpMethod.GET, "/webjars/swagger-ui/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/product/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/product/page").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/category/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/purchase-order/**")
                    .hasAuthority(Constants.SCOPE_ROLE_USER)
                    .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                    .anyRequest().authenticated()
            }
            .sessionManagement { session: SessionManagementConfigurer<HttpSecurity?> ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            }
            .formLogin { formLoginConfigurer: FormLoginConfigurer<HttpSecurity> -> formLoginConfigurer.disable() }
            .oauth2ResourceServer { oauth: OAuth2ResourceServerConfigurer<HttpSecurity?> -> oauth.jwt(Customizer.withDefaults()) }
            .build()
    }
}
