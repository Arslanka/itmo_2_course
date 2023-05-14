package com.arslanka.numericalintegration.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Response(
        @JsonProperty("message")
        String message
) {
}
