package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

public record SystemOfEquations<T extends BigDecimal, V extends BigDecimal>(
        List<BiFunction<T, V, BigDecimal>> equations
) {
}
