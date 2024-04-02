package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl : ProductService {
    override fun getById(id: UUID?): ProductDTO? {
        TODO("Not yet implemented")
    }

    override fun createProduct(productCreationDTO: ProductCreationDTO?): ProductDTO? {
        TODO("Not yet implemented")
    }

    override fun updateProduct(id: String?, productCreationDTO: ProductUpdateDTO?): ProductDTO? {
        TODO("Not yet implemented")
    }

    override fun getProductPage(
        pageRequest: ProductPageRequestDTO?,
        authentication: Authentication?
    ): PageResponseDTO<ProductDTO?>? {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: String?) {
        TODO("Not yet implemented")
    }
}