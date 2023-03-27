package math.linear;

import java.math.BigDecimal;
import java.util.List;

import exceptions.DivergenceException;
import math.linear.models.Matrix;
import org.jetbrains.annotations.NotNull;

public class PredominantDiagonalConverter {
    public static <T extends BigDecimal> @NotNull Matrix<T> convertToDiagonalPredominant(Matrix<T> extendedMatrix) {
        List<List<T>> sourceMatrix = extendedMatrix.getValues();
        int matrixSize = extendedMatrix.getRowSize();
        Matrix<T> newMatrix = new Matrix<>(matrixSize, matrixSize + 1);
        boolean[] fillOfNewMatrix = new boolean[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            BigDecimal maxInRow = BigDecimal.valueOf(Double.MIN_VALUE);
            int maxIndex = 0;

            for (int j = 0; j < matrixSize; j++) {
                if (sourceMatrix.get(i).get(j).abs().compareTo(maxInRow) >= 0) {
                    maxInRow = sourceMatrix.get(i).get(j).abs();
                    maxIndex = j;
                }
            }

            if (fillOfNewMatrix[maxIndex]) {
                throw new DivergenceException();
            }

            newMatrix.setRow(maxIndex, sourceMatrix.get(i));
            fillOfNewMatrix[maxIndex] = true;
        }

        if (ConvergenceChecker.checkDiagonalPredominance(newMatrix, matrixSize, matrixSize)) {
            return newMatrix;
        }
        throw new DivergenceException();
    }
}
