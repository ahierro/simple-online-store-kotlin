package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.dto.*
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*

@Service
class PurchaseOrderServiceImpl : PurchaseOrderService {
    override fun getById(id: UUID?): PurchaseOrderDTO? {
        TODO("Not yet implemented")
    }

    override fun createPurchaseOrder(
        categoryCreationDTO: PurchaseOrderCreationDTO?,
        authentication: Authentication?
    ): PurchaseOrderDTO? {
        TODO("Not yet implemented")
    }

    override fun patchPurchaseOrder(id: String?, categoryCreationDTO: PurchaseOrderPatchDTO?): PurchaseOrderDTO? {
        TODO("Not yet implemented")
    }

    override fun getPurchaseOrderPage(pageRequest: PageRequestDTO?): PageResponseDTO<PurchaseOrderViewDTO?>? {
        TODO("Not yet implemented")
    }
}