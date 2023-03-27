package math.linear.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import exceptions.MatrixColumnAmountException;
import exceptions.MatrixRowAmountException;

public class Matrix<T> {
    private final int rowSize;

    private final int columnSize;

    private final List<List<T>> values;

    public Matrix(final int rowSize, final int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.values = initValues(rowSize, columnSize);
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public List<List<T>> getValues() {
        return values;
    }

    public T getElementByIndex(int row, int column) {
        return values.get(row).get(column);
    }

    public List<T> getRowByIndex(int row) {
        return values.get(row);
    }

    public List<T> getColumnByIndex(int column) {
        List<T> vector = new ArrayList<>();
        for (int i = 0; i < rowSize; ++i) {
            vector.add(this.getElementByIndex(i, column));
        }
        return vector;
    }

    public void setElement(int row, int column, T el) {
        if (row > rowSize) {
            throw new MatrixRowAmountException(String.format("%s  %d %s %d", "Row position – ", row, "is more than " +
                    "requested matrix's rowSize", rowSize));
        }
        if (column > columnSize) {
            throw new MatrixColumnAmountException(String.format("%s  %d %s %d", "Column position – ", column, "is " +
                    "more than " +
                    "requested matrix's columnSize", columnSize));
        }

        if (row > values.size() - 1) {
            values.add(new ArrayList<>());
        }
        if (column > values.get(row).size() - 1) {
            values.get(row).add(column, el);
        } else {
            values.get(row).set(column, el);
        }
    }

    public void setRow(int row, List<T> elements) {
        if (row > rowSize) {
            throw new MatrixRowAmountException("Row position is more than requested matrix's rowSize");
        }
        for (int i = 0; i < columnSize; ++i) {
            setElement(row, i, elements.get(i));
        }
    }

    public void swapRows(int row1, int row2) {
        List<T> temp = values.get(row1);
        values.set(row1, values.get(row2));
        values.set(row2, temp);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<T> i : values) {
            stringBuilder.append(i.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private void fill(int rowSize, int columnSize, T val) {
        for (int i = 0; i < rowSize; ++i) {
            values.add(new ArrayList<>(columnSize));
            for (int j = 0; j < columnSize; ++j) {
                values.get(i).add(val);
            }
        }
    }

    public static <T extends BigDecimal> Matrix<T> of(List<List<T>> values, int rowSize, int columnSize) {
        Matrix<T> matrix = new Matrix<>(rowSize, columnSize);

        for (int i = 0; i < values.size(); ++i) {
            for (int j = 0; j < values.get(i).size(); ++j) {
                matrix.setElement(i, j, values.get(i).get(j));
            }
        }
        return matrix;
    }

    public static <T extends BigDecimal> Matrix<T> extendByVector(Matrix<T> matrix, List<T> vector) {
        if (vector.size() != matrix.columnSize) {
            throw new RuntimeException();
        }
        int pos = 0;
        List<List<T>> copyValues = new ArrayList<>(matrix.values);
        for (List<T> values : copyValues) {
            values.add(vector.get(pos++));
        }
        return Matrix.of(copyValues, copyValues.size(), copyValues.size());
    }

    private static <T> List<List<T>> initValues(final int rowSize, final int columnSize) {
        List<List<T>> matrixValues = new ArrayList<>(rowSize);
        for (int i = 0; i < rowSize; ++i) {
            matrixValues.add(new ArrayList<>(columnSize));
        }
        return matrixValues;
    }
}
