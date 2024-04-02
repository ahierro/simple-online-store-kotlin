package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import org.springframework.security.core.Authentication
import java.util.*

interface ProductService {
    fun getById(id: UUID?): ProductDTO?
    fun createProduct(productCreationDTO: ProductCreationDTO?): ProductDTO?
    fun updateProduct(id: String?, productCreationDTO: ProductUpdateDTO?): ProductDTO?
    fun getProductPage(
        pageRequest: ProductPageRequestDTO?,
        authentication: Authentication?
    ): PageResponseDTO<ProductDTO?>?

    fun deleteProduct(id: String?)
}
