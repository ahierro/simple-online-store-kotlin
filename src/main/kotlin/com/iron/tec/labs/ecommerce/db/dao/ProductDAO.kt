package com.iron.tec.labs.ecommerce.db.dao

import com.iron.tec.labs.ecommerce.db.entities.Product
import org.springframework.data.domain.Page

interface ProductDAO {
    fun findById(id: String): Product
    fun getPage(page: Int, size: Int): Page<Product>
    fun create(product: Product): Product
    fun update(product: Product): Product
    fun delete(id: String)
}