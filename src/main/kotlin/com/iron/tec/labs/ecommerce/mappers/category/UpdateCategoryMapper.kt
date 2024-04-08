package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryUpdateDTO
import org.springframework.core.convert.converter.Converter

interface UpdateCategoryMapper : Converter<CategoryUpdateDTO, Category> {
    override fun convert(source: CategoryUpdateDTO): Category
}