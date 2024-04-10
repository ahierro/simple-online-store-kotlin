package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.db.dao.ProductDAO
import com.iron.tec.labs.ecommerce.db.entities.Product
import com.iron.tec.labs.ecommerce.dto.*
import jakarta.transaction.Transactional
import org.springframework.core.convert.ConversionService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
@Transactional
class ProductServiceImpl(
    private val productDAO: ProductDAO,
    private val conversionService: ConversionService
) : ProductService {
    override fun getById(id: String): ProductDTO? {
        return conversionService.convert(productDAO.findById(id), ProductDTO::class.java)
    }

    override fun createProduct(productCreationDTO: ProductCreationDTO): ProductDTO {
        val productEntity = conversionService.convert(productCreationDTO, Product::class.java)
        val createdProduct = productDAO.create(productEntity!!)
        return conversionService.convert(createdProduct, ProductDTO::class.java)!!
    }

    override fun updateProduct(id: String, productDTO: ProductUpdateDTO): ProductDTO {
        productDTO.id = id
        val productEntity = conversionService.convert(productDTO, Product::class.java)
        val updateProduct = productDAO.update(productEntity!!)
        return conversionService.convert(updateProduct, ProductDTO::class.java)!!
    }

    override fun getProductPage(
        pageRequest: ProductPageRequestDTO,
        authentication: Authentication?
    ): PageResponseDTO<ProductDTO?>{
        val pageProduct = productDAO.getPage(pageRequest.page, pageRequest.size)
        return PageResponseDTO(
            pageProduct.content.stream()
                .map { x -> conversionService.convert(x, ProductDTO::class.java) }.toList(),
            pageProduct.pageable,
            pageProduct.totalElements
        )
    }

    override fun deleteProduct(id: String) {
        productDAO.delete(id)
    }
}