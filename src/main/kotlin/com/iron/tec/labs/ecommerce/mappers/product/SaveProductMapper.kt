package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductCreationDTO
import org.springframework.core.convert.converter.Converter

interface SaveProductMapper : Converter<ProductCreationDTO, Product> {
    override fun convert(source: ProductCreationDTO): Product
}