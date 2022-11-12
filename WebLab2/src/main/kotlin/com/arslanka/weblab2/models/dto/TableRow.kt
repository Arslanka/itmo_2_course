package com.arslanka.weblab2.models.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

data class TableRow(
    @get:JsonProperty("x", index = 0)
    val xCoor: BigDecimal,
    @get:JsonProperty("y", index = 1)
    val yCoor: BigDecimal,
    @get:JsonProperty("radius", index = 2)
    val radius: BigDecimal,
    @get:JsonProperty("hit", index = 3)
    val isHit: Boolean,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @get:JsonProperty("local_time", index = 4)
    val localTime: LocalDateTime,
)