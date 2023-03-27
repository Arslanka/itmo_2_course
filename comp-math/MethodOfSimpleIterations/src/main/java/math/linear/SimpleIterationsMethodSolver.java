package math.linear;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import exceptions.IterationsLimitException;
import exceptions.MatrixDimensionException;
import math.linear.models.Matrix;
import utils.Triple;

public class SimpleIterationsMethodSolver {
    private static final int MAX_ITERATIONS_QUANTITY = 50;

    public static <T extends BigDecimal> Matrix<T> findBeautifulMatrix(Matrix<T> matrix, List<T> vector) {
        return PredominantDiagonalConverter.convertToDiagonalPredominant(Matrix.extendByVector(matrix, vector));
    }

    public static <T extends BigDecimal> Triple<List<BigDecimal>, List<BigDecimal>, Integer> findSolution(Matrix<T> matrix, List<T> vector,
                                                                                                          BigDecimal accuracy) {
        if (matrix.getColumnSize() != matrix.getRowSize()) {
            throw new MatrixDimensionException("Quantity of rows != Quantity of columns");
        }

        List<List<BigDecimal>> resMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.getColumnSize(); ++i) {
            List<BigDecimal> resList = new ArrayList<>();
            for (int j = 0; j < matrix.getRowSize(); ++j) {
                if (i == j) {
                    resList.add(BigDecimal.ZERO);
                } else {
                    resList.add(matrix.getElementByIndex(i, j).negate().divide(matrix.getElementByIndex(i, i),
                            MathContext.DECIMAL128));
                }
            }
            resMatrix.add(resList);
        }

        List<BigDecimal> resVector = new ArrayList<>();
        for (int i = 0; i < matrix.getColumnSize(); ++i) {
            resVector.add(vector.get(i).divide(matrix.getElementByIndex(i, i), MathContext.DECIMAL128));
        }

        List<List<BigDecimal>> approxRoots = new ArrayList<>();
        approxRoots.add(resVector);

        int size = 1;
        List<BigDecimal> approx = new ArrayList<>();
        do {
            approxRoots.add(findCurrentApproxRoots(Matrix.of(resMatrix, resMatrix.size(), resMatrix.size()),
                    resVector, approxRoots.get(size - 1)));
            ++size;
            approx.add(calculateMaxApprox(approxRoots));
        } while (accuracy.compareTo(approx.get(size - 2)) <= 0 && size < MAX_ITERATIONS_QUANTITY);
        if (size >= MAX_ITERATIONS_QUANTITY) {
            throw new IterationsLimitException();
        }
        return Triple.of(approxRoots.get(approxRoots.size() - 1), approx, size - 1);
    }

    public static <T extends BigDecimal> List<BigDecimal> findCurrentApproxRoots(Matrix<T> matrix, List<T> vector,
                                                                                 List<BigDecimal> lastApproxRoots) {
        if (matrix.getRowSize() != matrix.getColumnSize()) {
            throw new MatrixDimensionException("Quantity of rows != Quantity of columns");
        }
        List<BigDecimal> curApproxRoots = new ArrayList<>();
        for (int i = 0; i < matrix.getColumnSize(); ++i) {
            BigDecimal res = vector.get(i);
            for (int j = 0; j < matrix.getRowSize(); ++j) {
                res = res.add(matrix.getElementByIndex(i, j).multiply(lastApproxRoots.get(j)));
            }
            curApproxRoots.add(res);
        }
        return curApproxRoots;
    }

    private static <T extends BigDecimal> BigDecimal calculateMaxApprox(List<List<T>> vectorOfVectors) {
        int size = vectorOfVectors.size();
        if (size < 2) {
            throw new RuntimeException();
        }
        List<T> last = vectorOfVectors.get(size - 1);
        List<T> beforeLast = vectorOfVectors.get(size - 2);
        BigDecimal mx = BigDecimal.ZERO;
        for (int i = 0; i < last.size(); ++i) {
            mx = (last.get(i).subtract(beforeLast.get(i), MathContext.DECIMAL128).abs().max(mx));
        }
        return mx;
    }

}
