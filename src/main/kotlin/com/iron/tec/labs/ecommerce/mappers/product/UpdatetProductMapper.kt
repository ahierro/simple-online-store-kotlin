package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductUpdateDTO
import org.springframework.core.convert.converter.Converter

interface UpdateProductMapper : Converter<ProductUpdateDTO, Product> {
    override fun convert(source: ProductUpdateDTO): Product
}