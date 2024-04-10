package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductDTO
import org.springframework.core.convert.converter.Converter

interface GetProductMapper : Converter<Product, ProductDTO> {
    override fun convert(source: Product): ProductDTO
}