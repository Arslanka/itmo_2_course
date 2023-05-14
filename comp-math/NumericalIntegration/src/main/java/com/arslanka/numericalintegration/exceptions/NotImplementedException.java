package com.arslanka.numericalintegration.exceptions;

public class NotImplementedException extends RuntimeException implements BusinessException {
    public NotImplementedException(String featureName) {
        super("Feature: %s is not implemented".formatted(featureName));
    }

    @Override
    public String message() {
        return this.getMessage();
    }
}
