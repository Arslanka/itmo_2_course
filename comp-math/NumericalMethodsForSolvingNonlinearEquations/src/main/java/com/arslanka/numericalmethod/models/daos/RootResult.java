package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.dtos.RootResultDto;

public record RootResult<T extends BigDecimal>(
        Integer numberIterations,
        T root,
        T res
) {

    public static <T extends BigDecimal> RootResult<T> of(Integer numberIterations, T root,
                                                                                   T res) {
        return new RootResult<>(numberIterations, root, res);
    }

    public RootResultDto toDto() {
        return new RootResultDto(
                numberIterations,
                root,
                res);
    }
}
