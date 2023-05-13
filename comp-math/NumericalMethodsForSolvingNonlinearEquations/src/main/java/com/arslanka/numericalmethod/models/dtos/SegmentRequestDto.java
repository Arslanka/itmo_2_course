package com.arslanka.numericalmethod.models.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SegmentRequestDto(
        @JsonProperty(value = "left", required = true)
        BigDecimal left,
        @JsonProperty(value = "right", required = true)
        BigDecimal right
) {
}
