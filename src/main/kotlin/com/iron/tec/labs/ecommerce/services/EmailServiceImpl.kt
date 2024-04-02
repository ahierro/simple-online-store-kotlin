package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.config.MailConfig
import org.slf4j.LoggerFactory
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(private val emailSender: JavaMailSender,
                       private val mailConfig: MailConfig) : EmailService {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Async
    override fun sendEmailInParallel(to: String, subject: String, body: String) {
        sendMailSync(to, subject, body)
    }

    override fun sendMailSync(to: String, subject: String, body: String) {
        try {
            val message = emailSender.createMimeMessage()
            val helper = MimeMessageHelper(message, true)
            helper.setTo(to)
            helper.setText(body, true)
            helper.setSubject(subject)
            helper.setFrom(mailConfig.username)
            emailSender.send(message)
        } catch (e: Exception) {
            log.error(e.message, e);
        }
    }
}
