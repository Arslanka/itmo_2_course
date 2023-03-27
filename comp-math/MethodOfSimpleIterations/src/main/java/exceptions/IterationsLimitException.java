package exceptions;

public class IterationsLimitException extends RuntimeException implements CustomException {
    public IterationsLimitException(String message) {
        super(message);
    }

    public IterationsLimitException() {
        super("Iterations limit exceeded");
    }
}
