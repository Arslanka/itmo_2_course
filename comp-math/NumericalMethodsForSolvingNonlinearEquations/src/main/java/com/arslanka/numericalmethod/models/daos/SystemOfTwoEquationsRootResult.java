package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;
import java.util.List;

import com.arslanka.numericalmethod.models.dtos.SystemOfTwoEquationsRootResultDto;

public record SystemOfTwoEquationsRootResult(
        List<BigDecimal> roots,
        List<Pair<BigDecimal, BigDecimal>> approxes,
        Integer numberOfIterations
) {

    public static SystemOfTwoEquationsRootResult of(final List<BigDecimal> roots, final List<Pair<BigDecimal,
            BigDecimal>> approxes, final Integer numberOfIterations) {
        return new SystemOfTwoEquationsRootResult(
                roots,
                approxes,
                numberOfIterations
        );
    }

    public SystemOfTwoEquationsRootResultDto toDto() {
        return new SystemOfTwoEquationsRootResultDto(
                this.numberOfIterations,
                this.roots,
                this.approxes
        );
    }
}
