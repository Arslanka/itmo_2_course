package exceptions;

public class MatrixRowAmountException extends RuntimeException implements CustomException {
    public MatrixRowAmountException(String name) {
        super(name);

    }
}
