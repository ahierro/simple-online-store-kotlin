package com.iron.tec.labs.ecommerce.mappers.user

import com.iron.tec.labs.ecommerce.db.entities.AppUser
import com.iron.tec.labs.ecommerce.dto.UserDTO
import org.springframework.core.convert.converter.Converter

interface GetUserMapper : Converter<UserDTO, AppUser> {
    override fun convert(source: UserDTO): AppUser?
}