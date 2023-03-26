package com.arslanka.weblab2.models.view

import java.math.BigDecimal

abstract class Shape {
    abstract fun isHit(radius: BigDecimal, x: BigDecimal, y: BigDecimal): Boolean
}