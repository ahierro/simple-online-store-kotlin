package com.iron.tec.labs.ecommerce.db.entities

import com.iron.tec.labs.ecommerce.db.converters.JpaConverterBoolean
import com.iron.tec.labs.ecommerce.db.converters.JpaConverterJson
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

@Entity(name = "USERS")
@EntityListeners(AuditingEntityListener::class)
data class AppUser(
    @Id
    var id: String,
    @JvmField final var username: String,
    @JvmField final var password: String,
    var email: @Email String,
    var firstName: String,
    var lastName: String,
    @Convert(converter = JpaConverterBoolean::class)
    var active: Boolean = true,
    @Convert(converter = JpaConverterBoolean::class)
    var locked: Boolean = false,
    @CreatedDate
    @Column(updatable=false)
    var createdAt: LocalDateTime? = null,
    @Convert(converter = JpaConverterJson::class)
    var authorities: List<String>
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.authorities.map { SimpleGrantedAuthority(it) }.toMutableList()
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return !locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return active
    }

    fun getSubject(): String {
        return id
    }

}
