package com.example.arslanka.weblab4.filters

import com.example.arslanka.weblab4.services.UserService
import com.example.arslanka.weblab4.uitls.Logging
import com.example.arslanka.weblab4.uitls.logger
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.tej.SwaggerCodgen.model.Error
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException

@Component
@Order(1)
class AuthenticationFilter(private val userService: UserService) : GenericFilterBean() {

    companion object : Logging {
        val log = logger()
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        try {
            val httpServletRequest = (request as HttpServletRequest)
            val lastUrlP = httpServletRequest.requestURL.split('/').last()
            httpServletRequest.headerNames.toList().forEach { println(it) }
            if (!httpServletRequest.headerNames.toList().contains("authorization")) {
                if (lastUrlP != "register" && lastUrlP != "login")
                    throw RuntimeException("Not enough level to interact")
                else chain.doFilter(request, response)
            } else {
                val headerParam = request.getHeader("authorization")
                if (headerParam == null || userService.findUserById(headerParam.toInt()) == null) throw RuntimeException(
                    "Not enough level to interact"
                )
                chain.doFilter(request, response)
            }
        } catch (e: java.lang.RuntimeException) {
            val error = Error(code = "", message = e.message!!)
            val httpServletResponse = (response as HttpServletResponse)
            httpServletResponse.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            response.writer.write(jacksonObjectMapper().writeValueAsString(error))
        }
    }
}