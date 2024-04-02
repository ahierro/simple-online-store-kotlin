package com.iron.tec.labs.ecommerce.controllers

import com.iron.tec.labs.ecommerce.dto.ValidationError
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.util.CollectionUtils
import org.springframework.validation.FieldError
import org.springframework.web.ErrorResponseException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandlerController {
    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(
        BadCredentialsException::class,
        InternalAuthenticationServiceException::class,
        AccessDeniedException::class,
        AuthenticationException::class
    )
    fun handleUnauthorized(ex: Exception): ProblemDetail {
        log.error(ex.message,ex)
        return ProblemDetail.forStatus(if ((ex is AccessDeniedException)) HttpStatus.FORBIDDEN else HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(ex: MethodArgumentNotValidException): ProblemDetail {
        val problemDetail = ex.body
        if (!CollectionUtils.isEmpty(ex.fieldErrors)) {
            problemDetail.setProperty("fieldErrors",
                ex.fieldErrors.stream().map { fieldError: FieldError ->
                    ValidationError(
                        fieldError.field,
                        fieldError.defaultMessage!!
                    )
                })
        }
        return problemDetail
    }

    @ExceptionHandler(ErrorResponseException::class)
    fun handleErrorResponseException(ex: ErrorResponseException): ProblemDetail {
        return ex.body
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ProblemDetail {
        log.error(ex.message,ex)
        return ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
