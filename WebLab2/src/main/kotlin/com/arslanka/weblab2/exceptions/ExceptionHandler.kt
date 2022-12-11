package com.arslanka.weblab2.exceptions

import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR
import java.lang.Exception

class ExceptionHandler {
    private val codeToStatus = mapOf(
        InvalidRequestException::class.java to HttpServletResponse.SC_BAD_REQUEST,
        JsonSerializationException::class.java to HttpServletResponse.SC_BAD_REQUEST,
        JsonDeserializationException::class.java to HttpServletResponse.SC_BAD_REQUEST,
        ForbiddenOperationException::class.java to HttpServletResponse.SC_FORBIDDEN,
    )

    fun <T : Exception> toStatusCodeMapper(ex: T): Int =
        codeToStatus[ex.javaClass] ?: SC_INTERNAL_SERVER_ERROR

}