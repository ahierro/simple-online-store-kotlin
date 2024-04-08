package com.iron.tec.labs.ecommerce.mappers.user

import com.iron.tec.labs.ecommerce.db.entities.AppUser
import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO
import org.springframework.core.convert.converter.Converter

interface RegisterUserMapper : Converter<RegisterUserDTO, AppUser> {
    override fun convert(source: RegisterUserDTO): AppUser?
}