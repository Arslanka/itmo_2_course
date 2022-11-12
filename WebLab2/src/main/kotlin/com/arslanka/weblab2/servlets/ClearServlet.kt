package com.arslanka.weblab2.servlets

import com.arslanka.weblab2.exceptions.InvalidRequestException
import com.arslanka.weblab2.models.dto.TableRow
import com.arslanka.weblab2.servlets.AreaCheckServlet.Companion.SESSION_TABLE_NAME
import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(
    name = "ClearServlet",
    urlPatterns = ["/clear", "clear-servlet"],
    loadOnStartup = 1,
)
class ClearServlet : BaseServlet() {

    companion object : Logging {
        val logger = logger()
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val requestParams = request.parameterNames.toList()
        if (requestParams.isNotEmpty() || request.inputStream.read() != -1) {
            logger.warn("The request shouldn't contain any parameters or body")
            throw InvalidRequestException(message = "The request shouldn't contain any parameters")
        }
        val tableFromSession = request.session.getAttribute(SESSION_TABLE_NAME)
        if (tableFromSession == null) {
            logger.info("Table is already empty")
        } else {
            val tableAsInstance = jackson.readValue(objClass = List::class.java, string = tableFromSession.toString())
            request.session.setAttribute(SESSION_TABLE_NAME, null)
            logger.info("${tableAsInstance.size + 1} rows was deleted from table. It is empty now.")
        }
        jackson.writeAsString(emptyList<TableRow>())
    }
}
