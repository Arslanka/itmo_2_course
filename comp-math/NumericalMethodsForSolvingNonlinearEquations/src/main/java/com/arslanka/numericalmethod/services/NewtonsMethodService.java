package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.utils.math.Differentiation;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import org.springframework.stereotype.Service;

@Service
public class NewtonsMethodService {
    public RootResult<BigDecimal> solveEquation(Equation<BigDecimal> equation,
                                                Segment<BigDecimal> segment, BigDecimal eps) {
        if (!FunctionUtils.isFunctionMonotony(equation, segment)) {
            throw new RuntimeException(); // todo custom exceptions
        }
        if (equation.substitute(segment.rightSide()).multiply(equation.substitute(segment.leftSide())).compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException();
        }
        if (equation.substitute(segment.leftSide()).multiply(Differentiation.findDerivativeResult(equation,
                segment.leftSide(), 2)).compareTo(BigDecimal.ZERO) < 0) {
            return solve(equation, segment.leftSide(), eps);
        } else if (equation.substitute(segment.rightSide()).multiply(Differentiation.findDerivativeResult(equation,
                segment.rightSide(), 2)).compareTo(BigDecimal.ZERO) < 0) {
            return solve(equation, segment.rightSide(), eps);
        } else {
            throw new RuntimeException();
        }
    }

    private RootResult<BigDecimal> solve(Equation<BigDecimal> equation, BigDecimal val, BigDecimal eps) {
        BigDecimal curApproxRes;
        BigDecimal prevApproxRes = val;
        Integer iterations = 0;
        do {
            curApproxRes = prevApproxRes.subtract(equation.substitute(prevApproxRes).divide(Differentiation.findDerivativeResult(equation, prevApproxRes, 1), MathContext.DECIMAL128));
            if (curApproxRes.subtract(prevApproxRes).compareTo(eps) < 0) {
                return RootResult.of(iterations, curApproxRes, equation.substitute(curApproxRes));
            }
            iterations++;
            prevApproxRes = curApproxRes;
        } while (true);
    }
}
