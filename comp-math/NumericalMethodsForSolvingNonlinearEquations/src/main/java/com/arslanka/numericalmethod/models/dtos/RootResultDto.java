package com.arslanka.numericalmethod.models.dtos;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RootResultDto {
    @JsonProperty(value = "numberOfIterations", index = 1)
    Integer numberOfIterations;
    @JsonProperty(value = "root", index = 2)
    BigDecimal root;
    @JsonProperty(value = "result", index = 3)
    BigDecimal result;
}
