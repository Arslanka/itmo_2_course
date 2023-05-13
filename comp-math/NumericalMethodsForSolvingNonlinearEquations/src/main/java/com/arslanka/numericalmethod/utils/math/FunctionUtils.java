package com.arslanka.numericalmethod.utils.math;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import com.arslanka.numericalmethod.models.daos.Function;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.utils.Utils;

public class FunctionUtils {
    private static final double EPS = 0.0001;

    public static boolean isFunctionMonotony(Function<BigDecimal> function,
                                             Segment<BigDecimal> segment) {
        boolean positive = segment.leftSide().compareTo(BigDecimal.ZERO) > 0;
        for (double i = segment.leftSide().doubleValue(); i <= segment.rightSide().doubleValue(); i += EPS) {
            BigDecimal val = BigDecimal.valueOf(i);
            if ((function.findDerivativeResult(function, val, 1).compareTo(BigDecimal.ZERO) < 0) && positive) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFunctionResultInSegment(Function<BigDecimal> function,
                                                    Segment<BigDecimal> domain, Segment<BigDecimal> segment,
                                                    Integer numberOfDerivative) {
        for (double i = domain.leftSide().doubleValue(); i <= domain.rightSide().doubleValue(); i += EPS) {
            if (!((function.findDerivativeResult(function, BigDecimal.valueOf(i), numberOfDerivative).compareTo(segment.rightSide()) < 0) &&
                    function.findDerivativeResult(function, BigDecimal.valueOf(i), numberOfDerivative).compareTo(segment.leftSide()) > 0)) {
                return false;
            }
        }
        return true;
    }

    public static BigDecimal functionMaxResultInSegment(Function<BigDecimal> function,
                                                        Segment<BigDecimal> domain, Segment<BigDecimal> segment,
                                                        Integer numberOfDerivative) {
        BigDecimal mx = function.findDerivativeResult(function, segment.leftSide(), numberOfDerivative).abs();
        for (double i = domain.leftSide().doubleValue(); i <= domain.rightSide().doubleValue(); i += EPS) {
            mx = Utils.max(function.findDerivativeResult(function, BigDecimal.valueOf(i), numberOfDerivative).abs(),
                    mx);
        }
        return mx;
    }

    public static BigDecimal functionMaxJacobianResultInSegments(BiFunction<BigDecimal, BigDecimal, BigDecimal> jacobian, Segment<BigDecimal> segment1, Segment<BigDecimal> segment2) {
        BigDecimal maxi = BigDecimal.valueOf(Double.MIN_VALUE);
        for (double l1 = segment1.leftSide().doubleValue(); l1 <= segment1.rightSide().doubleValue(); l1 += 0.01) {
            for (double l2 = segment2.leftSide().doubleValue(); l2 <= segment2.rightSide().doubleValue(); l2 += 0.01) {
                maxi = Utils.max(maxi, (jacobian.apply(BigDecimal.valueOf(l1), BigDecimal.valueOf(l2))).abs());
            }
        }
        return maxi;
    }
}
