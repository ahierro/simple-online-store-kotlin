package com.iron.tec.labs.ecommerce.controllers

import com.iron.tec.labs.ecommerce.dto.*
import com.iron.tec.labs.ecommerce.services.CategoryService
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
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/category")
@Tag(name = "Categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    @Operation(
        summary = "Get page of categories",
        parameters = [Parameter(
            `in` = ParameterIn.QUERY,
            name = "page",
            description = "Page"
        ), Parameter(`in` = ParameterIn.QUERY, name = "size", description = "Size")],
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = CategoryPage::class))]
        )]
    )
    @GetMapping("/page")
    fun getCategoriesPaged(@Valid pageRequest: PageRequestDTO): PageResponseDTO<CategoryDTO?> {
        return categoryService.getCategoryPage(pageRequest)
    }

    @Operation(
        summary = "Get Category Detail",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = CategoryDTO::class))]
        ), ApiResponse(responseCode = "404", description = "Not Found")]
    )
    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: String): CategoryDTO? {
        return categoryService.getById(id)
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Create Category",
        responses = [ApiResponse(
            responseCode = "201",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "409", description = "Resource already exists"), ApiResponse(
            responseCode = "401",
            description = "Authentication Failure",
        ), ApiResponse(responseCode = "403", description = "Forbidden")]
    )
    @PostMapping
    fun createCategory(
        @Valid @RequestBody categoryCreationDTO: CategoryCreationDTO,
        serverHttpRequest: HttpServletRequest
    ): ResponseEntity<Void> {
        val category = categoryService.createCategory(categoryCreationDTO)
        return ResponseEntity.created(
            URI.create(serverHttpRequest.requestURI + "/" + category.id)
        ).build()
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Update Category",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "401", description = "Authentication Failure"), ApiResponse(
            responseCode = "403",
            description = "Forbidden"
        ), ApiResponse(responseCode = "404", description = "Not Found")]
    )
    @PutMapping("/{id}")
    fun updateCategory(
        @PathVariable("id") id: String,
        @Valid @RequestBody category: CategoryUpdateDTO
    ): ResponseEntity<Void> {
        categoryService.updateCategory(id, category)
        return ResponseEntity.ok().build()
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Delete Category",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation"
        ), ApiResponse(responseCode = "401", description = "Authentication Failure"), ApiResponse(
            responseCode = "403",
            description = "Forbidden"
        ), ApiResponse(responseCode = "404", description = "Not Found")]
    )
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable("id") id: String): ResponseEntity<Void> {
        categoryService.deleteCategory(id)
        return ResponseEntity.ok().build()
    }
}
