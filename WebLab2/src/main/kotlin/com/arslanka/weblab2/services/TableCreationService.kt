package com.arslanka.weblab2.services

import com.arslanka.weblab2.models.dao.TableRow
import java.math.BigDecimal
import java.time.LocalDateTime

class TableCreationService {

    fun createRow(
        xCoor: BigDecimal,
        yCoor: BigDecimal,
        radius: BigDecimal,
        isHit: Boolean,
        localDateTime: LocalDateTime
    ): TableRow {
        return TableRow(
            xCoor = xCoor,
            yCoor = yCoor,
            radius = radius,
            isHit = isHit,
            localTime = localDateTime
        )
    }
}