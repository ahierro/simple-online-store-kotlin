package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import java.util.*

interface CategoryService {
    fun getById(id: UUID?): CategoryDTO?

    fun createCategory(categoryCreationDTO: CategoryCreationDTO?): CategoryDTO

    fun updateCategory(id: String?, categoryCreationDTO: CategoryUpdateDTO?): CategoryDTO?

    fun getCategoryPage(pageRequest: PageRequestDTO?): PageResponseDTO<CategoryDTO?>?

    fun deleteCategory(id: String?)
}
