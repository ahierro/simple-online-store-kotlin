package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductCreationDTO
import org.springframework.stereotype.Component

@Component
class SaveProductMapperImpl : SaveProductMapper {
    override fun convert(source: ProductCreationDTO): Product {
        return Product(
            id = source.productId,
            name= source.productName,
            description = source.productDescription,
            stock = source.stock,
            price = source.price,
            smallImageUrl = source.smallImageUrl,
            bigImageUrl = source.bigImageUrl,
            idCategory = source.categoryId,
        )
    }
}