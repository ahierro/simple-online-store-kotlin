package com.iron.tec.labs.ecommerce.db.converters

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter()
class JpaConverterBoolean : AttributeConverter<Boolean, Int> {
    override fun convertToDatabaseColumn(input: Boolean): Int {
        return if (input) 1 else 0
    }

    override fun convertToEntityAttribute(p0: Int): Boolean {
        return p0 == 1
    }

}