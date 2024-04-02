package com.iron.tec.labs.ecommerce.services

interface MessageService {
    fun getRequestLocalizedMessage(prefix: String, key: String): String

    fun getRequestLocalizedMessage(prefix: String, key: String, vararg params: String): String
}
