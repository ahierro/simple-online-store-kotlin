package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryDTO
import org.springframework.stereotype.Component

@Component
class GetCategoryMapperImpl : GetCategoryMapper {
    override fun convert(source: Category): CategoryDTO {
        return CategoryDTO(
            id = source.id!!,
            name = source.name,
            description = source.description,
            createdAt = source.createdAt,
            deleted = source.deleted
        )
    }
}