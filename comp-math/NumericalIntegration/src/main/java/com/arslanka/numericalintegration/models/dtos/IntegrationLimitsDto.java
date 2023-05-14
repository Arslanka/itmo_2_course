package com.arslanka.numericalintegration.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IntegrationLimitsDto(
        @JsonProperty("left")
        Double left,
        @JsonProperty("right")
        Double right
) {
    @Override
    public String toString() {
        return """
                {
                    "left": %f,
                    "right": %f
                }
                """.trim().formatted(left, right);
    }
}
