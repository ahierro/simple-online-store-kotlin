package com.iron.tec.labs.ecommerce.db.converters

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.io.IOException

@Converter()
class JpaConverterJson : AttributeConverter<Any?, String?> {
    override fun convertToDatabaseColumn(meta: Any?): String? {
        return try {
            objectMapper.writeValueAsString(meta)
        } catch (ex: JsonProcessingException) {
            null
            // or throw an error
        }
    }

    override fun convertToEntityAttribute(dbData: String?): Any? {
        return try {
            objectMapper.readValue(dbData, Any::class.java)
        } catch (ex: IOException) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            null
        }
    }

    companion object {
        private val objectMapper = ObjectMapper()
    }
}