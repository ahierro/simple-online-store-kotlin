package com.iron.tec.labs.ecommerce.db.entities

import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.domain.Persistable
import java.time.LocalDateTime
import java.util.*

//import org.springframework.data.relational.core.mapping.InsertOnlyProperty;

abstract class AuditableEntity : Persistable<UUID>{

//    @Id
//    var id: UUID? = null
    @Id
    private lateinit var id: UUID

    @CreatedDate //    @InsertOnlyProperty
    protected var createdAt: LocalDateTime? = null

    override fun isNew(): Boolean {
        return createdAt == null
    }

//    override fun getId(): UUID? {
//        return id
//    }
}
