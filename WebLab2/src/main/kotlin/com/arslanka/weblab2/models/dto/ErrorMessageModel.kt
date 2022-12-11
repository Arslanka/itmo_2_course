package com.arslanka.weblab2.models.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorMessageModel(
    @get:JsonProperty("code", index = 0)
    var statusCode: Int,
    @get:JsonProperty("message", index = 1)
    var message: String?,
)