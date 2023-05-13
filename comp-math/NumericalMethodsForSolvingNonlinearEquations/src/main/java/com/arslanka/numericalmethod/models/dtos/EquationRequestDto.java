package com.arslanka.numericalmethod.models.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EquationRequestDto(
        @JsonProperty(value = "equation_number", required = true)
        Integer equationNumber,

        @JsonProperty(value = "segment", required = true)
        SegmentRequestDto segment,

        @JsonProperty(value = "eps", required = true)
        BigDecimal eps
) {
}
