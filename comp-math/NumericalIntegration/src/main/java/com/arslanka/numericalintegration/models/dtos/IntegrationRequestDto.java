package com.arslanka.numericalintegration.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IntegrationRequestDto(
        @JsonProperty(value = "number_of_function", required = true)
        Integer numberOfFunction,

        @JsonProperty("modification")
        RectangleMethodModificationDto rectangleMethodModificationDto,
        @JsonProperty(value = "integration_limits", required = true)
        IntegrationLimitsDto integrationLimitsDto,

        @JsonProperty(value = "partition", required = true)
        Integer partition,
        @JsonProperty(value = "accuracy", required = true)
        Double accuracy
) {
    @Override
    public String toString() {
        return """
                {
                    number_of_function: %d,
                    integration_limits: %s,
                    partition: %d,
                    accuracy: %f
                }
                """.trim().formatted(numberOfFunction,
                integrationLimitsDto.toString(),
                partition,
                accuracy);
    }
}
