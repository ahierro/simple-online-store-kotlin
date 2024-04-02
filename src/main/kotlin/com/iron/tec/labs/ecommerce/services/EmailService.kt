package com.iron.tec.labs.ecommerce.services

interface EmailService {
    fun sendEmailInParallel(to: String, subject: String, body: String)
    fun sendMailSync(to: String, subject: String, body: String)
}
