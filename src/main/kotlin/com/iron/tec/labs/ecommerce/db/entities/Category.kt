package com.iron.tec.labs.ecommerce.db.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity(name = "CATEGORY")
@EntityListeners(AuditingEntityListener::class)
data class Category (
    @Id
    var id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val deleted: Boolean = false,
    @CreatedDate
    @Column(updatable=false)
    var createdAt: LocalDateTime? = null,
)