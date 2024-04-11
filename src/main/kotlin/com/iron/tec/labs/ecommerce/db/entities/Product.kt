package com.iron.tec.labs.ecommerce.db.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "PRODUCT")
@EntityListeners(AuditingEntityListener::class)
class Product(
    @Id
    @Access(AccessType.PROPERTY)
    open var id: String? = null,
    open val name: String? = null,
    open val description: String? = null,
    open val stock: Int? = null,
    open val price: BigDecimal? = null,
    open val smallImageUrl: String? = null,
    open val bigImageUrl: String? = null,
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = ForeignKey(name = "p_category_fk"))
    open val category: Category? = null,
    open val deleted: Boolean = false,
    @CreatedDate
    @Column(updatable = false)
    open var createdAt: LocalDateTime? = null,
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (stock != other.stock) return false
        if (price != other.price) return false
        if (smallImageUrl != other.smallImageUrl) return false
        if (bigImageUrl != other.bigImageUrl) return false
        if (category != other.category) return false
        if (deleted != other.deleted) return false
        if (createdAt != other.createdAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (stock ?: 0)
        result = 31 * result + (price?.hashCode() ?: 0)
        result = 31 * result + (smallImageUrl?.hashCode() ?: 0)
        result = 31 * result + (bigImageUrl?.hashCode() ?: 0)
        result = 31 * result + (category?.hashCode() ?: 0)
        result = 31 * result + deleted.hashCode()
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Product(id=$id, name=$name, description=$description, stock=$stock, price=$price, smallImageUrl=$smallImageUrl, bigImageUrl=$bigImageUrl, category=$category, deleted=$deleted, createdAt=$createdAt)"
    }


}