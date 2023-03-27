package com.arslanka.numericalmethod.utils.math;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Equation;
import com.arslanka.numericalmethod.models.daos.Segment;

public class FunctionUtils {
    public static final double EPS = 0.0001;

    public static boolean isFunctionMonotony(Equation<BigDecimal> equation,
                                             Segment<BigDecimal> segment) {
        boolean positive = segment.leftSide().compareTo(BigDecimal.ZERO) < 0;
        for (double i = segment.leftSide().doubleValue(); i <= segment.rightSide().doubleValue(); i += EPS) {
            BigDecimal val = BigDecimal.valueOf(i);
            if ((Differentiation.findDerivativeResult(equation, val, 1).compareTo(BigDecimal.ZERO) < 0) && positive) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFunctionResultInSegment(Equation<BigDecimal> equation,
                                                    Segment<BigDecimal> domain, Segment<BigDecimal> segment,
                                                    Integer numberOfDerivative) {
        for (double i = domain.leftSide().doubleValue(); i <= domain.rightSide().doubleValue(); i += EPS) {
            if (!((Differentiation.findDerivativeResult(equation, BigDecimal.valueOf(i), numberOfDerivative).compareTo(segment.rightSide()) < 0) &&
                    Differentiation.findDerivativeResult(equation, BigDecimal.valueOf(i), numberOfDerivative).compareTo(segment.leftSide()) > 0)) {
                return false;
            }
        }
        return true;
    }

    public static BigDecimal functionMaxResultInSegment(Equation<BigDecimal> equation,
                                                        Segment<BigDecimal> domain, Segment<BigDecimal> segment,
                                                        Integer numberOfDerivative) {
        BigDecimal mx = Differentiation.findDerivativeResult(equation, segment.leftSide(), numberOfDerivative).abs();
        for (double i = domain.leftSide().doubleValue(); i <= domain.rightSide().doubleValue(); i += EPS) {
            mx = Utils.max(Differentiation.findDerivativeResult(equation, BigDecimal.valueOf(i), numberOfDerivative).abs(), mx);
        }
        return mx;
    }


}
