package com.iron.tec.labs.ecommerce.services

import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(private val messageSource: ResourceBundleMessageSource) : MessageService {
    override fun getRequestLocalizedMessage(prefix: String, key: String): String {
        return messageSource.getMessage(
            concatPrefixAndKey(prefix, key),
            ArrayList<Any>().toTypedArray(),
            LocaleContextHolder.getLocale()
        )
    }

    override fun getRequestLocalizedMessage(prefix: String, key: String, vararg params: String): String {
        return messageSource.getMessage(concatPrefixAndKey(prefix, key), params, LocaleContextHolder.getLocale())
    }

    private fun concatPrefixAndKey(prefix: String?, key: String?): String {
        return "$prefix.$key"
    }
}