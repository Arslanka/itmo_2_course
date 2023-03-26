package com.arslanka.weblab2.services

import com.arslanka.weblab2.models.dao.Point2DWithRadius
import com.arslanka.weblab2.models.view.Graph
import com.arslanka.weblab2.utils.Logging
import com.arslanka.weblab2.utils.logger
import java.math.BigDecimal

class HitCheckService(private val graph: Graph) {

    companion object : Logging {
        val logger = logger()
    }

    fun checkHit(point2DWithRadius: Point2DWithRadius) =
        checkHit(
            radius = point2DWithRadius.radius,
            x = point2DWithRadius.point2D.x,
            y = point2DWithRadius.point2D.y
        ).also {
            logger.info("CheckHit returns $it for point $point2DWithRadius")
        }

    private fun checkHit(radius: BigDecimal, x: BigDecimal, y: BigDecimal) =
        graph.isHit(radius = radius, x = x, y = y)
}