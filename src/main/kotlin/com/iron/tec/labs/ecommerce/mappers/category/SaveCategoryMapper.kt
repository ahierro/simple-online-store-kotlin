package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryCreationDTO
import org.springframework.core.convert.converter.Converter

interface SaveCategoryMapper : Converter<CategoryCreationDTO, Category> {
    override fun convert(source: CategoryCreationDTO): Category
}