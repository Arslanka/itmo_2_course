package com.arslanka.weblab2.servlets

import com.arslanka.weblab2.configs.jspMainPage
import com.arslanka.weblab2.exceptions.InvalidRequestException
import com.arslanka.weblab2.servlets.AreaCheckServlet.Companion.FORWARD_SERVLET_NAME
import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(
    name = "ControllerServlet",
    urlPatterns = ["/main", "/main-page", "controller", "controller-servlet"],
    loadOnStartup = 0,
)
class ControllerServlet : BaseServlet() {

    companion object : Logging {
        val logger = logger()
        const val FORWARD_FLAG_NAME = "${FORWARD_SERVLET_NAME}.wasForwarded()"
    }

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val requestParams = request.parameterNames.toList()
        if (requestParams.isNotEmpty()) {
            logger.warn("The request shouldn't contain any parameters. Your parameters $requestParams")
            throw InvalidRequestException(message = "The request shouldn't contain any parameters")
        } else {
            request.getRequestDispatcher(jspMainPage).forward(request, response)
            logger.info("Main page was received successfully")
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val requestParams = request.parameterNames.toList()
        if (requestParams.isNotEmpty()) {
            logger.warn("The request shouldn't contain any parameters. Your parameters $requestParams")
            throw InvalidRequestException(message = "The request shouldn't contain any parameters")
        }
        servletContext.setAttribute(FORWARD_FLAG_NAME, true)
        logger.info("Request was forwarded to $FORWARD_SERVLET_NAME")
        servletContext.getRequestDispatcher(FORWARD_SERVLET_NAME).forward(request, response)
        servletContext.setAttribute(FORWARD_FLAG_NAME, false)
    }
}