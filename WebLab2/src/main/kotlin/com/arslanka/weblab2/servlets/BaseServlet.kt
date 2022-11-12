package com.arslanka.weblab2.servlets

import com.arslanka.weblab2.Backend
import com.arslanka.weblab2.configs.returnContentType
import com.arslanka.weblab2.exceptions.ExceptionHandler
import com.arslanka.weblab2.models.dto.ErrorMessageModel
import com.arslanka.weblab2.utils.Jackson
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

abstract class BaseServlet : HttpServlet() {

    companion object {
        val backend = Backend()
        val jackson = Jackson(ObjectMapper().findAndRegisterModules())
        val exceptionHandler = ExceptionHandler()
    }

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        try {
            super.service(req, res)
        } catch (ex: java.lang.Exception) {
            res.toErrorHttpResponse(ex)
        }
    }

    private fun HttpServletResponse.toErrorHttpResponse(ex: Exception) = this.also {
        it.contentType = returnContentType
        it.status = exceptionHandler.toStatusCodeMapper(ex)
        it.writer.println(
            jackson.writeAsString(
                ErrorMessageModel(
                    statusCode = it.status,
                    message = ex.message,
                )
            )
        )
    }
}