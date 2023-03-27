package com.arslanka.numericalmethod.models.daos;

import java.math.BigDecimal;
import java.math.MathContext;

public interface Equation<T> {
    BigDecimal substitute(T x);
    default Equation<T> add(Equation<T> equation) {
        return x -> substitute(x).add(equation.substitute(x));
    }

    default Equation<T> add(BigDecimal var) {
        return x -> substitute(x).add(var);
    }

    default Equation<T> subtract(Equation<T> equation) {
        return x -> substitute(x).subtract(equation.substitute(x));
    }

    default Equation<T> subtract(BigDecimal var) {
        return x -> substitute(x).subtract(var);
    }

    default Equation<T> multiply(Equation<T> equation) {
        return x -> this.substitute(x).multiply(equation.substitute(x));
    }

    default Equation<T> multiply(BigDecimal var) {
        return x -> this.substitute(x).multiply(var);
    }

    default Equation<T> divide(Equation<T> equation) {
        return x -> this.substitute(x).divide(equation.substitute(x), MathContext.DECIMAL128);
    }

    default Equation<T> divide(BigDecimal var) {
        return x -> this.substitute(x).divide(var, MathContext.DECIMAL128);
    }
}
