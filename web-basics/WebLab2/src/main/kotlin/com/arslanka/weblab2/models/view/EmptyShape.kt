package com.arslanka.weblab2.models.view

import java.math.BigDecimal

class EmptyShape : Shape() {
    override fun isHit(radius: BigDecimal, x: BigDecimal, y: BigDecimal): Boolean {
        return false
    }
}