package com.arslanka.weblab2.filters

import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import jakarta.servlet.*
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest


@WebFilter("/*")
class ControllerServletFilter : Filter {
    private lateinit var context: ServletContext

    companion object : Logging {
        val logger = logger()
    }

    override fun init(fConfig: FilterConfig) {
        this.context = fConfig.servletContext
        logger.info("ControllerServletFilter was initialized")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        val requestParameterNames = (request as HttpServletRequest).parameterNames
        while (requestParameterNames.hasMoreElements()) {
            val name = requestParameterNames.nextElement()
            val value = request.getParameter(name)
            logger.info("Request with IP address: ${request.getRemoteAddr()} ::Request Params::{ $name = $value }")
        }
        val cookies = request.cookies
        if (cookies != null) {
            for (cookie in cookies)
                logger.info("Request with IP address: ${request.getRemoteAddr()} ::Cookie::{ ${cookie.name}, ${cookie.value} }")
        } else {
            logger.info("Request with IP address: ${request.getRemoteAddr()}, new User was registered")
        }
        filterChain.doFilter(request, response)
    }
}