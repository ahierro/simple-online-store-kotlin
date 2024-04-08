package com.iron.tec.labs.ecommerce.db.dao

import com.iron.tec.labs.ecommerce.constants.Constants.ALREADY_EXISTS
import com.iron.tec.labs.ecommerce.constants.Constants.ERROR_CATEGORY
import com.iron.tec.labs.ecommerce.constants.Constants.NOT_FOUND
import com.iron.tec.labs.ecommerce.db.entities.Category
import com.iron.tec.labs.ecommerce.db.repository.CategoryRepository
import com.iron.tec.labs.ecommerce.exceptions.Conflict
import com.iron.tec.labs.ecommerce.exceptions.NotFound
import com.iron.tec.labs.ecommerce.services.MessageService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.TransientDataAccessResourceException
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CategoryDAOImpl(
    private val categoryRepository: CategoryRepository,
    private val messageService: MessageService
) : CategoryDAO {

    override fun findById(id: String): Category {
        return categoryRepository.findById(id).orElseThrow {
            throw NotFound(messageService.getRequestLocalizedMessage(ERROR_CATEGORY, NOT_FOUND, id))
        }!!
    }

    override fun getPage(page: Int, size: Int): Page<Category> {
        val pageRequest = PageRequest.of(page, size)
        val example: Example<Category> = Example.of(Category())
        return categoryRepository.findBy(example) { queryFunction ->
            queryFunction.sortBy(Sort.by("createdAt").descending()).page(pageRequest)
        }
    }

    override fun create(category: Category): Category {
        try {
            return categoryRepository.save(category)
        } catch (e: DataIntegrityViolationException) {
            throw Conflict(
                messageService.getRequestLocalizedMessage(ERROR_CATEGORY, ALREADY_EXISTS, category.id!!)
            )
        }
    }

    override fun update(category: Category): Category {
        try {
            return categoryRepository.save(category)
        } catch (e: TransientDataAccessResourceException) {
            throw Conflict(
                messageService.getRequestLocalizedMessage(ERROR_CATEGORY, NOT_FOUND, category.id!!)
            )
        }
    }

    override fun delete(id: String) {
        try {
            val numberOfDeletedRows = categoryRepository.deleteCategoryById(id)
            if (numberOfDeletedRows == 0) {
                throw NotFound(messageService.getRequestLocalizedMessage(ERROR_CATEGORY, NOT_FOUND, id))
            }
        } catch (e: DataIntegrityViolationException) {
            throw Conflict(
                messageService.getRequestLocalizedMessage(ERROR_CATEGORY, ALREADY_EXISTS, id)
            )
        }
    }
}