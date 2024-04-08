package com.iron.tec.labs.ecommerce.services

import com.iron.tec.labs.ecommerce.constants.Constants.ERROR_USER
import com.iron.tec.labs.ecommerce.constants.Constants.NOT_FOUND
import com.iron.tec.labs.ecommerce.db.entities.AppUser
import com.iron.tec.labs.ecommerce.db.repository.UserRepository
import com.iron.tec.labs.ecommerce.dto.RegisterUserDTO
import com.iron.tec.labs.ecommerce.exceptions.NotFound
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.ErrorResponseException
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val emailService: EmailService,
    private val messageService: MessageService
) : UserService {
    override fun loadUserByUsername(userName: String?): UserDetails {
        val userDetails: UserDetails = userRepository.findByUsername(userName)
            ?: throw UsernameNotFoundException(userName)
        return userDetails
    }

    override fun create(user: RegisterUserDTO): UserDetails {
        try {
            val userCreated = userRepository.save(
                AppUser(
                    id = UUID.randomUUID().toString(),
                    username = user.username,
                    password = passwordEncoder.encode(user.password),
                    firstName = user.firstName,
                    lastName = user.lastName,
                    email = user.email,
                    active = false,
                    authorities = listOf(if (user.isAdmin) "ROLE_ADMIN" else "ROLE_USER")
                )
            )
            emailService.sendEmailInParallel(
                userCreated.email,
                "Welcome to EcommerceJava! - Please confirm your e-mail",
                "Welcome to EcommerceJava ${userCreated.firstName}! Please confirm your e-mail by clicking on the following link:<a href=\"http://localhost:8080/api/confirm?token=${userCreated.id} \">Confirm Mail!</a>"
            )
            return userCreated
        } catch (e: DataIntegrityViolationException) {
            throw ErrorResponseException(
                HttpStatus.CONFLICT,
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.CONFLICT,
                    "User already exist"
                ), e
            )
        }
    }

    override fun confirm(token: String): String {
        val user = userRepository.findByIdAndActive(token, false)
            ?: throw NotFound(
                messageService.getRequestLocalizedMessage(
                    ERROR_USER,
                    NOT_FOUND
                )
            )
        user.active = true
        userRepository.save(user)
        return "User " + user.username + " confirmed!"
    }

}
