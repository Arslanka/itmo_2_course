package com.arslanka.numericalmethod.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.arslanka.numericalmethod.models.daos.Pair;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SystemOfEquations;
import com.arslanka.numericalmethod.models.daos.SystemOfTwoEquationsRootResult;
import com.arslanka.numericalmethod.utils.math.FunctionUtils;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public class SimpleIterationsSystemEquationMethodService {

    public SystemOfTwoEquationsRootResult solveSystemOfEquations(SystemOfEquations<BigDecimal,
            BigDecimal> systemOfEquations,
                                                                 BiFunction<BigDecimal, BigDecimal,
                                                                         BigDecimal> jacobian,
                                                                 Segment<BigDecimal> segment1,
                                                                 Segment<BigDecimal> segment2,
                                                                 BigDecimal eps) throws ExecutionControl.NotImplementedException {
        if (systemOfEquations.equations().size() != 2) {
            throw new ExecutionControl.NotImplementedException("");
        }
        if (FunctionUtils.functionMaxJacobianResultInSegments(jacobian, segment1, segment2).compareTo(BigDecimal.ONE) > 0) {
            throw new RuntimeException();
        }

        return solve(systemOfEquations, segment1, segment2, eps);
    }

    public SystemOfTwoEquationsRootResult solve(SystemOfEquations<BigDecimal, BigDecimal> systemOfEquations,
                                                Segment<BigDecimal> segment1,
                                                Segment<BigDecimal> segment2, BigDecimal eps) {

        var prevX1Approx = segment1.rightSide();
        var curX1Approx = prevX1Approx;
        var prevX2Approx = segment2.rightSide();
        var curX2Approx = prevX2Approx;
        int numberOfIterations = 0;
        var listOfApproxes = new ArrayList<Pair<BigDecimal, BigDecimal>>();
        do {
            prevX1Approx = curX1Approx;
            prevX2Approx = curX2Approx;
            curX1Approx = systemOfEquations.equations().get(0).apply(prevX1Approx, prevX2Approx);
            curX2Approx = systemOfEquations.equations().get(1).apply(prevX1Approx, prevX2Approx);
            numberOfIterations++;
            listOfApproxes.add(Pair.of(curX1Approx.subtract(prevX1Approx).abs(),
                    curX2Approx.subtract(prevX2Approx).abs()));

        } while (listOfApproxes.get(numberOfIterations - 1).first().compareTo(eps) >= 0 ||
                listOfApproxes.get(numberOfIterations - 1).second().compareTo(eps) >= 0
        );
        return SystemOfTwoEquationsRootResult.of(List.of(curX1Approx, curX2Approx), listOfApproxes, numberOfIterations);
    }

}
