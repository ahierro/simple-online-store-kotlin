package com.iron.tec.labs.ecommerce.db.repository

import com.iron.tec.labs.ecommerce.db.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product?, String> {
    @Modifying
    @Query("update com.iron.tec.labs.ecommerce.db.entities.Product set deleted = true where id = :id and deleted = false ")
    fun deleteProductById(id: String): Int
}