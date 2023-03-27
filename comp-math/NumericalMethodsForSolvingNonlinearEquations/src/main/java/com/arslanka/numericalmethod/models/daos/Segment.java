package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

public record Segment<T extends BigDecimal>(
        T leftSide,
        T rightSide
) {
    public static <T extends BigDecimal> Segment<T> of(T leftSide,
                                                       T rightSide) {
        return new Segment<>(leftSide, rightSide);
    }
}
