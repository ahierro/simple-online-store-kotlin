package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryServiceImpl: CategoryService {
    override fun getById(id: UUID?): CategoryDTO? {
        TODO("Not yet implemented")
    }

    override fun createCategory(categoryCreationDTO: CategoryCreationDTO?): CategoryDTO {
        TODO("Not yet implemented")
    }

    override fun updateCategory(id: String?, categoryCreationDTO: CategoryUpdateDTO?): CategoryDTO? {
        TODO("Not yet implemented")
    }

    override fun getCategoryPage(pageRequest: PageRequestDTO?): PageResponseDTO<CategoryDTO?>? {
        TODO("Not yet implemented")
    }

    override fun deleteCategory(id: String?) {
        TODO("Not yet implemented")
    }
}