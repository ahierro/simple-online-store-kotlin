package com.iron.tec.labs.ecommerce.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

@Configuration
data class MailConfig(
    @Value("\${spring.mail.host}")
    val host: String,
    @Value("\${spring.mail.port}")
    val port: Int,
    @Value("\${spring.mail.username}")
    val username: String,
    @Value("\${spring.mail.password}")
    val password: String,
    @Value("\${spring.mail.properties.mail.smtp.auth}")
    val auth: String,
    @Value("\${spring.mail.properties.mail.smtp.starttls.enable}")
    val starttls: String,
    @Value("\${spring.mail.properties.mail.transport.protocol}")
    val protocol: String,
    @Value("\${spring.mail.properties.mail.debug}")
    val debug: String
) {

    @Bean
    fun getJavaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = host
        mailSender.port = port
        mailSender.username = username
        mailSender.password = password

        val props = mailSender.javaMailProperties
        props["mail.transport.protocol"] = protocol
        props["mail.smtp.auth"] = auth
        props["mail.smtp.starttls.enable"] = starttls
        props["mail.debug"] = debug
        return mailSender
    }
}
