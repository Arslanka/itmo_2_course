import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.CustomException;
import math.linear.SimpleIterationsMethodSolver;
import math.linear.models.Matrix;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        while (true) {
            System.out.println('\n' + ANSI_GREEN + "Solving a system of linear equations using the *method of simple " +
                    "iterations*");
            System.out.println("""
                    Choose the method of the data entry:\s
                    > 1 - console input
                    > 2 - input from the file
                    > 3 - stop the program""");
            try {
                var strategy = scanner.nextInt();
                var in = new Scanner(System.in);
                if (strategy == 2) {
                    System.out.print("Please enter the file name: ");
                    var fileName = scanner.next().trim();
                    in = new Scanner(new FileInputStream(fileName));
                } else if (strategy == 3) {
                    break;
                } else {
                    System.out.println("""
                            Please enter the accuracy, size of matrix, and matrix. Ex:\s
                                0.01 3
                                2 2 10   14
                                10 1 1   12
                                2 10 1   13""");
                    System.out.println(">");
                }
                var accuracy = new BigDecimal(in.next().trim().replace(',', '.'));
                var size = in.nextInt();
                Matrix<BigDecimal> matrix = new Matrix<>(size, size);
                List<BigDecimal> vector = new ArrayList<>();
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j <= size; ++j) {
                        if (j != size) {
                            matrix.setElement(i, j, new BigDecimal(in.next().trim().replace(',', '.')));
                        } else {
                            vector.add(new BigDecimal(in.next().trim().replace(',', '.')));
                        }
                    }
                }

                var extendedBeautifyMatrix = SimpleIterationsMethodSolver.findBeautifulMatrix(matrix,
                        vector);

                var solution =
                        SimpleIterationsMethodSolver.findSolution(Matrix.of(extendedBeautifyMatrix.getValues(), size,
                                        size),
                                extendedBeautifyMatrix.getColumnByIndex(size), accuracy);

                System.out.println(ANSI_GREEN + "Result vector is: " + solution.first());
                System.out.println(ANSI_GREEN + "Vector of approx: " + solution.second());
                System.out.println(ANSI_GREEN + "Quantity of iterations: " + solution.third());
            } catch (InputMismatchException exception) {
                System.out.println(ANSI_RED + "You have entered incorrect data. Please input it carefully");
            } catch (FileNotFoundException exception) {
                System.out.println(ANSI_RED + "You have entered incorrect fileName.");
            } catch (Exception exception) {
                if (exception instanceof CustomException) {
                    System.out.println(ANSI_RED + exception.getMessage());
                } else {
                    exception.printStackTrace();
                }
            }
        }
    }
}