package com.arslanka.weblab2.models.dao

import java.math.BigDecimal
import java.time.LocalDateTime

data class TableRow(
    val xCoor: BigDecimal,
    val yCoor: BigDecimal,
    val radius: BigDecimal,
    val isHit: Boolean,
    val localTime: LocalDateTime,
)