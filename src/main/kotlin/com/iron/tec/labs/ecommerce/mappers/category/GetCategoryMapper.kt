package com.iron.tec.labs.ecommerce.mappers.category

import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.CategoryDTO
import org.springframework.core.convert.converter.Converter

interface GetCategoryMapper : Converter<Category, CategoryDTO> {
    override fun convert(source: Category): CategoryDTO
}