package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Function;
import com.arslanka.numericalmethod.models.daos.RootResult;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import org.springframework.stereotype.Service;

@Service
public class NewtonsMethodService {
    public RootResult<BigDecimal> solveEquation(Function<BigDecimal> function,
                                                Segment<BigDecimal> segment, BigDecimal eps) {

        if (!FunctionUtils.isFunctionMonotony(function, segment)) {
            throw new RuntimeException(); // todo custom exceptions
        }
        if (function.substitute(segment.rightSide()).multiply(function.substitute(segment.leftSide())).compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException();
        }
        if (function.substitute(segment.leftSide()).multiply(function.findDerivativeResult(function,
                segment.leftSide(), 2)).compareTo(BigDecimal.ZERO) < 0) {
            return solve(function, segment.leftSide(), eps);
        } else if (function.substitute(segment.rightSide()).multiply(function.findDerivativeResult(function,
                segment.rightSide(), 2)).compareTo(BigDecimal.ZERO) < 0) {
            return solve(function, segment.rightSide(), eps);
        } else {
            throw new RuntimeException();
        }
    }

    private RootResult<BigDecimal> solve(Function<BigDecimal> function, BigDecimal val, BigDecimal eps) {
        BigDecimal curApproxRes;
        BigDecimal prevApproxRes = val;
        Integer iterations = 0;
        do {
            curApproxRes = prevApproxRes.subtract(function.substitute(prevApproxRes).divide(function.findDerivativeResult(function, prevApproxRes, 1), MathContext.DECIMAL128));
            if (curApproxRes.subtract(prevApproxRes).compareTo(eps) < 0) {
                return RootResult.of(iterations, curApproxRes, function.substitute(curApproxRes));
            }
            iterations++;
            prevApproxRes = curApproxRes;
        } while (true);
    }
}
