package com.iron.tec.labs.ecommerce.controllers

import com.iron.tec.labs.ecommerce.dto.*
import com.iron.tec.labs.ecommerce.services.PurchaseOrderService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/purchase-order")
@Tag(name = "Purchase Orders")
class PurchaseOrderController(//    private val log = LoggerFactory.getLogger(this::class.java)
    private val purchaseOrderService: PurchaseOrderService
) {
    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        parameters = [Parameter(
            `in` = ParameterIn.QUERY,
            name = "page",
            description = "Page"
        ), Parameter(`in` = ParameterIn.QUERY, name = "size", description = "Size")],
        summary = "Get page of purchase orders",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = PurchaseOrderPage::class)
            )]
        )]
    )
    @GetMapping("/page")
    fun getPurchaseOrdersPaged(
        pageRequest: @Valid PageRequestDTO?,
        authentication: Authentication?
    ): PageResponseDTO<PurchaseOrderViewDTO?>? {
        return purchaseOrderService.getPurchaseOrderPage(pageRequest)
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Get Purchase Order Detail",
        responses = [ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = PurchaseOrderDTO::class)
            )]
        ), ApiResponse(responseCode = "404", description = "Not Found", content = [Content()])]
    )
    @GetMapping("/{id}")
    fun getPurchaseOrder(
        @PathVariable id: UUID?,
        authentication: Authentication?
    ): PurchaseOrderDTO? {
        return purchaseOrderService.getById(id)
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Create Purchase Order",
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
    fun createPurchaseOrder(
        @RequestBody purchaseOrderCreationDTO: @Valid PurchaseOrderCreationDTO?,
        serverHttpRequest: HttpRequest,
        authentication: Authentication?
    ): ResponseEntity<Void> {
        purchaseOrderService.createPurchaseOrder(purchaseOrderCreationDTO, authentication)

        return ResponseEntity.created(URI.create(serverHttpRequest.uri.path.toString() + "/" + purchaseOrderCreationDTO!!.id))
            .build()
    }

    @Operation(
        security = [SecurityRequirement(name = "bearer-key")],
        summary = "Patch Category",
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
    @PatchMapping("/{id}")
    fun patchPurchaseOrder(
        @PathVariable("id") id: String?,
        @RequestBody purchaseOrder: @Valid PurchaseOrderPatchDTO?
    ): ResponseEntity<Void> {
        purchaseOrderService.patchPurchaseOrder(id, purchaseOrder)
        return ResponseEntity.ok().build()
    }
}
