package math.linear;

import java.math.BigDecimal;

import math.linear.models.Matrix;

public class ConvergenceChecker {
    public static <T extends BigDecimal> boolean checkDiagonalPredominance(Matrix<T> matrix, int rowSize, int columnSize) {
        BigDecimal diagonalSum = BigDecimal.ZERO, otherSum = BigDecimal.ZERO;
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (i == j) {
                    diagonalSum = diagonalSum.add(matrix.getElementByIndex(i, j).abs());
                } else {
                    otherSum = otherSum.add(matrix.getElementByIndex(i, j).abs());
                }
            }
        }
        return diagonalSum.compareTo(otherSum) >= 0;
    }
}
