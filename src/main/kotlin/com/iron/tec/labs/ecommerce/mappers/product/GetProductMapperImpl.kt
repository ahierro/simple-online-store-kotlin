package com.iron.tec.labs.ecommerce.mappers.product

import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.ProductDTO
import com.iron.tec.labs.ecommerce.mappers.category.GetCategoryMapper
import org.springframework.stereotype.Component

@Component
class GetProductMapperImpl(val getCategoryMapper: GetCategoryMapper) : GetProductMapper {
    override fun convert(source: Product): ProductDTO {
        return ProductDTO(
            productId = source.id!!,
            productName = source.name,
            productDescription = source.description,
            stock = source.stock,
            price = source.price,
            smallImageUrl = source.smallImageUrl,
            bigImageUrl = source.bigImageUrl,
            category = getCategoryMapper.convert(source.category!!),
            createdAt = source.createdAt,
            deleted = source.deleted
        )
    }
}