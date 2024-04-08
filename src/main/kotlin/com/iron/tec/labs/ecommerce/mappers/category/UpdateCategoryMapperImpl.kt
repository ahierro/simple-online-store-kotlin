package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryUpdateDTO
import org.springframework.stereotype.Component

@Component
class UpdateCategoryMapperImpl : UpdateCategoryMapper{
    override fun convert(source: CategoryUpdateDTO): Category {
        return Category(
            id = source.id,
            name= source.name,
            description = source.description
        )
    }
}