package exceptions;

public class MatrixColumnAmountException extends RuntimeException implements CustomException {
    public MatrixColumnAmountException(String name) {
        super(name);
    }
}

