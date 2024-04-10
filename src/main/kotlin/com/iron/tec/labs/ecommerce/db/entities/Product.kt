package com.iron.tec.labs.ecommerce.db.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "PRODUCT")
@EntityListeners(AuditingEntityListener::class)
data class Product(
    @Id
    var id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val stock: Int? = null,
    val price: BigDecimal? = null,
    val smallImageUrl: String? = null,
    val bigImageUrl: String? = null,
    val idCategory: String? = null,
    val deleted: Boolean = false,
    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime? = null,
    )