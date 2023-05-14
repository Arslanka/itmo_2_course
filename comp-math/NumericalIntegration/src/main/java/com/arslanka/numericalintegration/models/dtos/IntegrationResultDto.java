package com.arslanka.numericalintegration.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IntegrationResultDto(
        @JsonProperty("integration_result")
        Double result,
        @JsonProperty("partition")
        Integer partition
) {

    public static <T extends Double> IntegrationResultDto of(T result, Integer partition) {
        return new IntegrationResultDto(result, partition);
    }

    @Override
    public String toString() {
        return """
                {
                    "result": %f
                }
                """.trim().formatted(result);
    }
}
