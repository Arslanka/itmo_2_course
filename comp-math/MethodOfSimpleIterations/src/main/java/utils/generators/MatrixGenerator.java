package utils.generators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import math.linear.models.Matrix;

public class MatrixGenerator {
    public static <T extends BigDecimal> Matrix<BigDecimal> generate(int rowSize, int columnSize) {
        List<List<BigDecimal>> randomListsOfList = new ArrayList<>();
        for (int i = 0; i < rowSize; ++i) {
            List<BigDecimal> list = new ArrayList<>();
            for (int j = 0; j < columnSize; ++j) {
                list.add(BigDecimal.valueOf((new Random().nextDouble())));
            }
            randomListsOfList.add(list);
        }
        return Matrix.of(randomListsOfList, rowSize, columnSize);
    }
}
