package com.arslanka.weblab2.servlets

import com.arslanka.weblab2.configs.returnContentType
import com.arslanka.weblab2.exceptions.InvalidRequestException
import com.arslanka.weblab2.servlets.AreaCheckServlet.Companion.SESSION_TABLE_NAME
import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


@WebServlet(
    name = "TableRequestServlet",
    urlPatterns = ["/table", "/table-request"],
    loadOnStartup = 1,
)
class TableRequestServlet : BaseServlet() {

    companion object : Logging {
        val logger = logger()
    }

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val requestParams = request.parameterNames.toList()
        if (requestParams.isNotEmpty()) {
            logger.warn("The request shouldn't contain any parameters. Your parameters $requestParams")
            throw InvalidRequestException(message = "The request shouldn't contain any parameters")
        } else {
            val tableFromSession = request.session.getAttribute(SESSION_TABLE_NAME)
            response.contentType = returnContentType
            response.writer.println(tableFromSession)
            logger.info("Table was sent to the client")
        }
    }
}
