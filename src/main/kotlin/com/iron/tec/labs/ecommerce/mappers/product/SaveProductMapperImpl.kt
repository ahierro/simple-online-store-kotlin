package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductCreationDTO
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SaveProductMapperImpl(val em: EntityManager) : SaveProductMapper {

    override fun convert(source: ProductCreationDTO): Product {
        return Product(
            id = source.productId,
            name= source.productName,
            description = source.productDescription,
            stock = source.stock,
            price = source.price,
            smallImageUrl = source.smallImageUrl,
            bigImageUrl = source.bigImageUrl,
            category = em.getReference(Category::class.java,source.categoryId),
        )
    }
}