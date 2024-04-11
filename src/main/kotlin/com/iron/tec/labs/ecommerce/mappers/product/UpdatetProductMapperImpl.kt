package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductUpdateDTO
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class UpdateProductMapperImpl(val em: EntityManager) : UpdateProductMapper {
    override fun convert(source: ProductUpdateDTO): Product {
        return Product(
            id = source.id,
            name = source.productName,
            description = source.productDescription,
            stock = source.stock,
            price = source.price,
            smallImageUrl = source.smallImageUrl,
            bigImageUrl = source.bigImageUrl,
            category = em.getReference(Category::class.java, source.categoryId),
        )
    }
}