package com.arslanka.weblab2.models.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

data class ClientRequestInfo(
    @JsonProperty("x")
    val xCoor: BigDecimal,
    @JsonProperty("y")
    val yCoor: BigDecimal,
    @JsonProperty("radius")
    val radius: BigDecimal,
    @JsonProperty("local_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val localTime: LocalDateTime,
)


