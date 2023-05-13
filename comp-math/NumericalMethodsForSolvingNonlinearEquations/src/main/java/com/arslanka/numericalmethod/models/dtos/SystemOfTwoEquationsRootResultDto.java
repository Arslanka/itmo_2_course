package com.arslanka.numericalmethod.models.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.arslanka.numericalmethod.models.daos.Pair;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SystemOfTwoEquationsRootResultDto {
    @JsonProperty(value = "numberOfIterations", index = 1)
    Integer numberOfIterations;
    @JsonProperty(value = "roots", index = 2)
    List<BigDecimal> roots;
    @JsonProperty(value = "approxes", index = 3)
    List<Pair<BigDecimal, BigDecimal>> approxes;
}
