import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SimpleIterationsMethodSolverTest {

    @ParameterizedTest
    @CsvSource(value = {"matrix_ex_1.txt", "matrix_ex_2.txt", "matrix_ex_3.txt"})
    public void findRootsSuccessfully(String fileName) {

    }
}
