package com.iron.tec.labs.ecommerce.db.repository

import com.iron.tec.labs.ecommerce.db.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category?, String> {
    @Modifying
    @Query("update com.iron.tec.labs.ecommerce.db.entities.Category set deleted = true where id = :id and deleted = false ")
    fun deleteCategoryById(id: String): Int
}