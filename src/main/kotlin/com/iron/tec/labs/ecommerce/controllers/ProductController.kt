package com.iron.tec.labs.ecommerce.controllers

import com.iron.tec.labs.ecommerce.dto.*
import com.iron.tec.labs.ecommerce.services.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/product")
@Tag(name = "Products")
class ProductController(private val productService: ProductService) {
    @Operation(
        summary = "Get page of products",
        parameters = [Parameter(
            `in` = ParameterIn.QUERY,
            name = "page",
            description = "Page"
        ), Parameter(`in` = ParameterIn.QUERY, name = "size", description = "Size")],
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductPage::class))]
        )]
    )
    @GetMapping("/page")
    fun getProductsPaged(
        @Valid pageRequest: ProductPageRequestDTO,
        authentication: Authentication?
    ): PageResponseDTO<ProductDTO?>? {
        return productService.getProductPage(pageRequest, authentication)
    }

    @Operation(
        summary = "Get Product Detail",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductDTO::class))]
        ), ApiResponse(responseCode = "404", description = "Not Found", content = [Content()])]
    )
    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String): ProductDTO? {
        return productService.getById(id)
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Create Product",
        responses = [ApiResponse(
            responseCode = "201",
            description = "Successful Operation",
            content = [Content()]
        ), ApiResponse(
            responseCode = "409",
            description = "Resource already exists",
            content = [Content()]
        ), ApiResponse(
            responseCode = "401",
            description = "Authentication Failure",
            content = [Content()]
        ), ApiResponse(responseCode = "403", description = "Forbidden", content = [Content()])]
    )
    @PostMapping
    fun createProduct(
        @Valid @RequestBody productCreationDTO: ProductCreationDTO,
        serverHttpRequest: HttpServletRequest
    ): ResponseEntity<Void> {
        productService.createProduct(productCreationDTO)
        return ResponseEntity.created(
            URI.create(serverHttpRequest.requestURI + "/" + productCreationDTO.productId)
        ).build()
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Update Product",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content()]
        ), ApiResponse(
            responseCode = "401",
            description = "Authentication Failure",
            content = [Content()]
        ), ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = [Content()]
        ), ApiResponse(responseCode = "404", description = "Not Found", content = [Content()])]
    )
    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable("id") id: String,
        @Valid @RequestBody product: ProductUpdateDTO
    ): ResponseEntity<Void> {
        productService.updateProduct(id, product)
        return ResponseEntity.ok().build()
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Delete Product",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content()]
        ), ApiResponse(
            responseCode = "401",
            description = "Authentication Failure",
            content = [Content()]
        ), ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = [Content()]
        ), ApiResponse(responseCode = "404", description = "Not Found", content = [Content()])]
    )
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: String): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity.ok().build()
    }
}
