package com.iron.tec.labs.ecommerce.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
class NotAuthorized : RuntimeException {
    constructor()

    constructor(message: String?) : super(message)
}
