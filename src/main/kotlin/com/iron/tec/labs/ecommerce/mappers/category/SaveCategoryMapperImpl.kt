package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryCreationDTO
import org.springframework.stereotype.Component

@Component
class SaveCategoryMapperImpl : SaveCategoryMapper {
    override fun convert(source: CategoryCreationDTO): Category {
        return Category(
            id = source.id,
            name= source.name,
            description = source.description
        )
    }
}