package utils;

public record Triple<T, U, V>(T first, U second, V third) {
    public static <T, U, V> Triple<T, U, V> of(T t, U u, V v) {
        return new Triple<>(t, u, v);
    }
}