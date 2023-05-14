package com.arslanka.numericalintegration.models.daos;

public record IntegrationResult(
        Double result,
        Integer partition
) {

    public static <T extends Double> IntegrationResult of(T result, Integer partition) {
        return new IntegrationResult(result, partition);
    }
}
