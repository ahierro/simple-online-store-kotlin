package com.iron.tec.labs.ecommerce.db.dao

import com.iron.tec.labs.ecommerce.db.entities.Category
import org.springframework.data.domain.Page

interface CategoryDAO {
    fun findById(id: String): Category
    fun getPage(page: Int, size: Int): Page<Category>
    fun create(category: Category): Category
    fun update(category: Category): Category
    fun delete(id: String)
}