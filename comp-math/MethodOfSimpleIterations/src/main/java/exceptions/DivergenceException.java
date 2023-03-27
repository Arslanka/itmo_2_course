package exceptions;

public class DivergenceException extends RuntimeException implements CustomException {

    public DivergenceException() {
        super("The dominance of the diagonal is not observed");
    }

    public DivergenceException(String name) {
        super(name);
    }

}
