package exceptions;

public class MatrixDimensionException extends RuntimeException implements CustomException {
    public MatrixDimensionException(String message) {
        super(message);
    }
}
