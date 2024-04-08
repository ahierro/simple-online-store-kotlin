package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.db.dao.CategoryDAO
import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.dto.*
import jakarta.transaction.Transactional
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service

@Service
@Transactional
class CategoryServiceImpl(
    private val categoryDAO: CategoryDAO,
    private val conversionService: ConversionService
) : CategoryService {

    override fun getById(id: String): CategoryDTO? {
        return conversionService.convert(categoryDAO.findById(id), CategoryDTO::class.java)
    }

    override fun createCategory(categoryCreationDTO: CategoryCreationDTO): CategoryDTO {
        val categoryEntity = conversionService.convert(categoryCreationDTO, Category::class.java)
        val createdCategory = categoryDAO.create(categoryEntity!!)
        return conversionService.convert(createdCategory, CategoryDTO::class.java)!!
    }

    override fun updateCategory(id: String, categoryDTO: CategoryUpdateDTO): CategoryDTO {
        categoryDTO.id = id
        val categoryEntity = conversionService.convert(categoryDTO, Category::class.java)
        val updateCategory = categoryDAO.update(categoryEntity!!)
        return conversionService.convert(updateCategory, CategoryDTO::class.java)!!
    }

    override fun getCategoryPage(pageRequest: PageRequestDTO): PageResponseDTO<CategoryDTO?> {
        val pageCategory = categoryDAO.getPage(pageRequest.page, pageRequest.size)
        return PageResponseDTO(
            pageCategory.content.stream()
                .map { x -> conversionService.convert(x, CategoryDTO::class.java) }.toList(),
            pageCategory.pageable,
            pageCategory.totalElements
        )
    }
    override fun deleteCategory(id: String) {
        categoryDAO.delete(id)
    }
}