package com.iron.tec.labs.ecommerce.db.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity(name = "CATEGORY")
@EntityListeners(AuditingEntityListener::class)
@Access(AccessType.FIELD)
class Category (
    @Id
    @Access(AccessType.PROPERTY)
    open var id: String? = null,
    open val name: String? = null,
    open val description: String? = null,
    open val deleted: Boolean = false,
    @CreatedDate
    @Column(updatable=false)
    open var createdAt: LocalDateTime? = null,
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (deleted != other.deleted) return false
        if (createdAt != other.createdAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + deleted.hashCode()
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Category(id=$id, name=$name, description=$description, deleted=$deleted, createdAt=$createdAt)"
    }

}