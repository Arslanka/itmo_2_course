package com.arslanka.weblab2.models.view

import java.math.BigDecimal

class Graph(
    private val topLeft: Shape? = null,
    private val topRight: Shape? = null,
    private val botRight: Shape? = null,
    private val botLeft: Shape? = null,
) {

    fun isHit(radius: BigDecimal, x: BigDecimal, y: BigDecimal): Boolean {
        if (topLeft != null && x <= BigDecimal.ZERO && y >= BigDecimal.ZERO)
            return topLeft.isHit(radius, x, y)
        else if (topRight != null && x >= BigDecimal.ZERO && y >= BigDecimal.ZERO)
            return topRight.isHit(radius, x, y)
        else if (botRight != null && x >= BigDecimal.ZERO && y <= BigDecimal.ZERO)
            return botRight.isHit(radius, x, y)
        else if (botLeft != null && x <= BigDecimal.ZERO && y <= BigDecimal.ZERO)
            return botLeft.isHit(radius, x, y)
        return false
    }
}
