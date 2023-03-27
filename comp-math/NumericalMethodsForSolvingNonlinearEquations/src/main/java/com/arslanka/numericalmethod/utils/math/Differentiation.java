package com.arslanka.numericalmethod.utils.math;

import java.math.BigDecimal;
import java.math.MathContext;

import com.arslanka.numericalmethod.models.daos.Equation;

public class Differentiation {
    private static final BigDecimal EPS = BigDecimal.valueOf(0.001);

    public static <T extends BigDecimal> BigDecimal findDerivativeResult(Equation<BigDecimal> equation,

                                                                         BigDecimal val, Integer numberOfDerivative) {
        if (numberOfDerivative < 1) {
            return equation.substitute(val);
        } else if (numberOfDerivative == 1) {
            return equation.substitute(val.add(EPS)).subtract(equation.substitute(val)).divide(EPS,
                    MathContext.DECIMAL128);
        } else {
            return findDerivativeResult(equation,
                    equation.substitute(val.add(EPS)).subtract(equation.substitute(val)).divide(EPS,
                            MathContext.DECIMAL128),
                    numberOfDerivative - 1);

        }
    }
}
