package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Function;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import org.springframework.stereotype.Service;

@Service
public class HalfDivisionMethodService {

    public RootResult<BigDecimal> solveEquation(Function<BigDecimal> function,
                                                Segment<BigDecimal> segment, BigDecimal eps) {
        if (!FunctionUtils.isFunctionMonotony(function, segment)) {
            throw new RuntimeException();
        }
        if (function.substitute(segment.rightSide()).multiply(function.substitute(segment.leftSide())).compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException();
        }
        return solve(function, segment.leftSide(), segment.rightSide(), eps);
    }

    private RootResult<BigDecimal> solve(Function<BigDecimal> function, BigDecimal left, BigDecimal right,
                                         BigDecimal eps) {
        BigDecimal curApproxRes;
        Integer iterations = 0;
        do {
            curApproxRes = left.add(right).divide(BigDecimal.valueOf(2), MathContext.DECIMAL128);
            if (right.subtract(left).abs().compareTo(eps) <= 0) {
                return RootResult.of(iterations, curApproxRes, right.subtract(left).abs());
            }
            if (function.substitute(left).multiply(function.substitute(curApproxRes)).compareTo(BigDecimal.ZERO) > 0) {
                left = curApproxRes;
            } else {
                right = curApproxRes;
            }
            iterations++;
        } while (true);
    }
}
