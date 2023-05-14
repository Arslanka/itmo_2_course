package com.arslanka.numericalintegration.exceptions;

public class ValueIsOutOfBoundException extends RuntimeException implements BusinessException {
    public ValueIsOutOfBoundException(String value, Double lowerBound, Double upperBound) {
        super("Value: %s is out of bound: ( %f, %f )".formatted(value, lowerBound, upperBound));
    }

    @Override
    public String message() {
        return this.getMessage();
    }
}
