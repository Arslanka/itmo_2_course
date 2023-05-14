package com.arslanka.numericalintegration.models.daos;

public record IntegrationLimits(
        Double left,
        Double right
) {
    public static <T extends Double> IntegrationLimits of(T left, T right) {
        return new IntegrationLimits(left, right);
    }
}
