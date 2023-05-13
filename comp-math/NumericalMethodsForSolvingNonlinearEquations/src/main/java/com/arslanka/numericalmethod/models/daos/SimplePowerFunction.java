package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record SimplePowerFunction(
        Integer power
) implements Function<BigDecimal> {
    @Override
    public BigDecimal substitute(BigDecimal x) {
        return x.pow(power);
    }
}