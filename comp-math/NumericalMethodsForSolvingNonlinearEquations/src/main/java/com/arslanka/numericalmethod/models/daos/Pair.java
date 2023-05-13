package com.arslanka.numericalmethod.models.daos;

public record Pair<T, S>(
        T first,
        S second
) {
    public static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }
}