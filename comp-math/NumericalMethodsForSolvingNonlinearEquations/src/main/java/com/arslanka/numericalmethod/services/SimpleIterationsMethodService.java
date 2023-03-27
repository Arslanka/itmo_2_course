package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SimplePowerEquation;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import org.springframework.stereotype.Service;

@Service
public class SimpleIterationsMethodService {

    public RootResult<BigDecimal> solveEquation(Equation<BigDecimal> equation,
                                                Segment<BigDecimal> segment, BigDecimal eps) {
        if (FunctionUtils.isFunctionResultInSegment(equation, segment, Segment.of(BigDecimal.valueOf(-1),
                BigDecimal.valueOf(1)), 1)) {
            throw new RuntimeException();
        }
        return solve(equation, segment, segment.leftSide(), eps);
    }

    private RootResult<BigDecimal> solve(Equation<BigDecimal> equation, Segment<BigDecimal> segment, BigDecimal val,
                                         BigDecimal eps) {
        var lambda = (BigDecimal.valueOf(-1)).divide(FunctionUtils.functionMaxResultInSegment(equation, segment,
                segment, 1), MathContext.DECIMAL128);
        equation = equation.multiply(lambda).add(new SimplePowerEquation(1));
        BigDecimal curApproxRes;
        BigDecimal prevApproxRes = val;
        Integer iterations = 0;
        do {
            curApproxRes = equation.substitute(prevApproxRes);
            if (curApproxRes.subtract(prevApproxRes).compareTo(eps) < 0) {
                return RootResult.of(iterations, curApproxRes, equation.substitute(curApproxRes));
            }
            iterations++;
            prevApproxRes = curApproxRes;
        } while (true);
    }
}
