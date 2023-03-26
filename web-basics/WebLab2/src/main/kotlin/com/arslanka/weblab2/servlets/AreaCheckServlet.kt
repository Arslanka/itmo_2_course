package com.arslanka.weblab2.servlets

import com.arslanka.weblab2.configs.returnContentType
import com.arslanka.weblab2.exceptions.ForbiddenOperationException
import com.arslanka.weblab2.models.dto.ClientRequestInfo
import com.arslanka.weblab2.servlets.ControllerServlet.Companion.FORWARD_FLAG_NAME
import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import com.arslanka.weblab2.utils.toDtoTableRow
import com.arslanka.weblab2.utils.toPointWithRadius
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(
    name = "AreaCheckServlet",
    urlPatterns = ["/check", "/checker", "area-check", "area-check-servlet"],
    loadOnStartup = 0,
)
class AreaCheckServlet : BaseServlet() {

    companion object : Logging {
        val logger = logger()
        const val SESSION_TABLE_NAME = "table"
        const val FORWARD_SERVLET_NAME = "/area-check"
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        logger.info("Servlet: $this was called")
        val forwardFlag = servletContext.getAttribute(FORWARD_FLAG_NAME)
        if (forwardFlag == null || forwardFlag == false) {
            logger.debug("This endpoint call is forbidden. There is no rules for user ${request.remoteUser}")
            throw ForbiddenOperationException("This endpoint call is forbidden without redirect")
        }
        val clientRequestInfo =
            jackson.readValue(objClass = ClientRequestInfo::class.java, stream = request.inputStream)
        val point2DWithRadius = clientRequestInfo.toPointWithRadius()
        val tableRow = backend.tableCreationService.createRow(
            xCoor = point2DWithRadius.point2D.x,
            yCoor = point2DWithRadius.point2D.y,
            radius = point2DWithRadius.radius,
            isHit = backend.hitCheckService.checkHit(point2DWithRadius),
            localDateTime = clientRequestInfo.localTime
        )
        val tableFromSession = request.session.getAttribute(SESSION_TABLE_NAME)
        val tableDtoAsJson = listOf(tableRow.toDtoTableRow())
        if (tableFromSession == null) {
            request.session.setAttribute(SESSION_TABLE_NAME, jackson.writeAsString(tableDtoAsJson).also {
                response.contentType = returnContentType
                response.writer.println(it)
            }
            )
            logger.info("Session was started, table contains 1 row with data")
        } else {
            val tableAsInstance =
                jackson.readValue(objClass = List::class.java, string = tableFromSession.toString())
            request.session.setAttribute(SESSION_TABLE_NAME,
                jackson.writeAsString((tableAsInstance).plus(tableDtoAsJson)).also {
                    response.contentType = returnContentType
                    response.writer.println(it)
                }
            )
            logger.info("Table contains ${tableAsInstance.size + 1} row with data")
        }

    }
}