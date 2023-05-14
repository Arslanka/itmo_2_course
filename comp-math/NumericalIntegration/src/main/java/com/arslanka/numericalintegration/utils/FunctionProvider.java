package com.arslanka.numericalintegration.utils;

import java.util.function.Function;

import com.arslanka.numericalintegration.exceptions.NotImplementedException;


public class FunctionProvider {
    private static final Function<Double, Double> FUNCTION_1 = (x) -> x * x;
    private static final Function<Double, Double> FUNCTION_2 = Math::sin;
    private static final Function<Double, Double> FUNCTION_3 = (x) -> 2 * x + 1;

    public static Function<Double, Double> getFunctionByNumber(Integer num) {
        switch (num) {
            case 1 -> {
                return FUNCTION_1;
            }
            case 2 -> {
                return FUNCTION_2;
            }
            case 3 -> {
                return FUNCTION_3;
            }
            default -> throw new NotImplementedException("enum field %d".formatted(num));
        }
    }
}
