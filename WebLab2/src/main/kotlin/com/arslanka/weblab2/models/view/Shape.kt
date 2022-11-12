package com.arslanka.weblab2.models.view

import java.math.BigDecimal

interface Shape {
    fun isHit(radius: BigDecimal, x: BigDecimal, y: BigDecimal): Boolean
}