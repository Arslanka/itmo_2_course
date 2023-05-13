package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Function;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SimplePowerFunction;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import org.springframework.stereotype.Service;

@Service
public class SimpleIterationsMethodService {

    public RootResult<BigDecimal> solveEquation(Function<BigDecimal> function,
                                                Segment<BigDecimal> segment, BigDecimal eps) {
        if (FunctionUtils.isFunctionResultInSegment(function, segment, Segment.of(BigDecimal.valueOf(-1),
                BigDecimal.valueOf(1)), 1)) {
            throw new RuntimeException(); // todo custom exceptions
        }
        return solve(function, segment, segment.leftSide(), eps);
    }

    private RootResult<BigDecimal> solve(Function<BigDecimal> function, Segment<BigDecimal> segment, BigDecimal val,
                                         BigDecimal eps) {
        var lambda = (BigDecimal.valueOf(-1)).divide(FunctionUtils.functionMaxResultInSegment(function, segment,
                segment, 1), MathContext.DECIMAL128);
        function = function.multiply(lambda).add(new SimplePowerFunction(1));
        BigDecimal curApproxRes;
        BigDecimal prevApproxRes = val;
        Integer iterations = 0;
        do {
            curApproxRes = function.substitute(prevApproxRes);
            if (curApproxRes.subtract(prevApproxRes).compareTo(eps) < 0) {
                return RootResult.of(iterations, curApproxRes, curApproxRes.subtract(prevApproxRes));
            }
            iterations++;
            prevApproxRes = curApproxRes;
        } while (true);
    }
}
