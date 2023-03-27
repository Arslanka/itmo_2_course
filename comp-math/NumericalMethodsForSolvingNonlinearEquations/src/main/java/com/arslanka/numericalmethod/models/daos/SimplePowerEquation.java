package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record SimplePowerEquation(
        Integer power
) implements Equation<BigDecimal> {
    @Override
    public BigDecimal substitute(BigDecimal x) {
        return x.pow(power);
    }
}