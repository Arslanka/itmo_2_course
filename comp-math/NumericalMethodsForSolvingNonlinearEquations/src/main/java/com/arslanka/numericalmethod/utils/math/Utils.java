package com.arslanka.numericalmethod.utils.math;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        if (first.compareTo(second) > 0) {
            return first;
        } else {
            return second;
        }
    }
}
