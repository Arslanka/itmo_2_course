package com.arslanka.weblab2.models.dao

import java.math.BigDecimal

data class Point2DWithRadius(
    val point2D: Point2D,
    val radius: BigDecimal
)