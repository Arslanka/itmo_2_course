package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record SimpleExponentialEquation<T extends Integer>(
        BigDecimal basis
) implements Equation<T> {

    @Override
    public BigDecimal substitute(T x) {
        return basis.pow(x);
    }
}
