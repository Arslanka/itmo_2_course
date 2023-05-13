package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;
import java.math.MathContext;

public interface Function<T> {
    BigDecimal EPS = BigDecimal.valueOf(0.001);
    BigDecimal substitute(T x);

    default Function<T> add(Function<T> function) {
        return x -> substitute(x).add(function.substitute(x));
    }

    default Function<T> add(BigDecimal var) {
        return x -> substitute(x).add(var);
    }

    default Function<T> subtract(Function<T> function) {
        return x -> substitute(x).subtract(function.substitute(x));
    }

    default Function<T> subtract(BigDecimal var) {
        return x -> substitute(x).subtract(var);
    }

    default Function<T> multiply(Function<T> function) {
        return x -> this.substitute(x).multiply(function.substitute(x));
    }

    default Function<T> multiply(BigDecimal var) {
        return x -> this.substitute(x).multiply(var);
    }

    default Function<T> divide(Function<T> function) {
        return x -> this.substitute(x).divide(function.substitute(x), MathContext.DECIMAL128);
    }

    default Function<T> divide(BigDecimal var) {
        return x -> this.substitute(x).divide(var, MathContext.DECIMAL128);
    }

    default BigDecimal findDerivativeResult(Function<BigDecimal> function,

                                            BigDecimal val, Integer numberOfDerivative) {
        if (numberOfDerivative < 1) {
            return function.substitute(val);
        } else if (numberOfDerivative == 1) {
            return function.substitute(val.add(EPS)).subtract(function.substitute(val)).divide(EPS,
                    MathContext.DECIMAL128);
        } else {
            return findDerivativeResult(function,
                    function.substitute(val.add(EPS)).subtract(function.substitute(val)).divide(EPS,
                            MathContext.DECIMAL128),
                    numberOfDerivative - 1);

        }
    }
}
