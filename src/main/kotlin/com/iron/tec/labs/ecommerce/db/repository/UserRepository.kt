package com.iron.tec.labs.ecommerce.db.repository

import com.iron.tec.labs.ecommerce.db.entities.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<AppUser?, String> {
    fun findByIdAndActive(id: String, active: Boolean): AppUser?

    fun findByUsername(username: String?): AppUser?
}
