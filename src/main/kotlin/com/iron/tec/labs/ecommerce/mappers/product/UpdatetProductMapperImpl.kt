package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductUpdateDTO
import org.springframework.stereotype.Component

@Component
class UpdateProductMapperImpl : UpdateProductMapper {
    override fun convert(source: ProductUpdateDTO): Product {
        return Product(
            id = source.id,
            name = source.productName,
            description = source.productDescription,
            stock = source.stock,
            price = source.price,
            smallImageUrl = source.smallImageUrl,
            bigImageUrl = source.bigImageUrl,
        )
    }
}