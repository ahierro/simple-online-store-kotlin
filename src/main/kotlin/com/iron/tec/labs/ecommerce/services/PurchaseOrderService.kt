package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import org.springframework.security.core.Authentication
import java.util.*

interface PurchaseOrderService {
    fun getById(id: UUID?): PurchaseOrderDTO?

    fun createPurchaseOrder(
        categoryCreationDTO: PurchaseOrderCreationDTO?,
        authentication: Authentication?
    ): PurchaseOrderDTO?

    fun patchPurchaseOrder(id: String?, categoryCreationDTO: PurchaseOrderPatchDTO?): PurchaseOrderDTO?

    fun getPurchaseOrderPage(pageRequest: PageRequestDTO?): PageResponseDTO<PurchaseOrderViewDTO?>?
}
