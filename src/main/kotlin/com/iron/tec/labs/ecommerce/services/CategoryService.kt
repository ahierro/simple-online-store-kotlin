package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*

interface CategoryService {
    fun getById(id: String): CategoryDTO?

    fun createCategory(categoryCreationDTO: CategoryCreationDTO): CategoryDTO

    fun updateCategory(id: String, categoryDTO: CategoryUpdateDTO): CategoryDTO

    fun getCategoryPage(pageRequest: PageRequestDTO): PageResponseDTO<CategoryDTO?>

    fun deleteCategory(id: String)
}
