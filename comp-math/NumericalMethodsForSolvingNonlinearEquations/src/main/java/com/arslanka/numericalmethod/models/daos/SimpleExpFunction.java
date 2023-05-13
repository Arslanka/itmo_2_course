package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record SimpleExpFunction(
        BigDecimal basis
) implements Function<BigDecimal> {

    @Override
    public BigDecimal substitute(BigDecimal x) {
        return BigDecimal.valueOf(Math.pow(basis.doubleValue(), x.doubleValue()));
    }
}
