package com.arslanka.numericalintegration.services;

import java.util.function.Function;

import com.arslanka.numericalintegration.exceptions.ValueIsOutOfBoundException;
import com.arslanka.numericalintegration.models.daos.IntegrationLimits;
import com.arslanka.numericalintegration.models.daos.IntegrationResult;
import org.springframework.stereotype.Service;

@Service
public class SimpsonIntegrationMethodService {

    private static final Integer SIMPSON_ACCURACY_ORDER = 4;
    private static final Double PARTITION_MAX_VALUE = 1E8;

    private static final Double EPS_MIN_VALUE = 1E-6;

    public IntegrationResult solve(Function<Double, Double> function,
                                   IntegrationLimits limits,
                                   Integer partition,
                                   double accuracy

    ) {
        if (accuracy < EPS_MIN_VALUE) {
            throw new ValueIsOutOfBoundException("accuracy", EPS_MIN_VALUE, 1E8);
        }
        if (partition <= 0) {
            throw new ValueIsOutOfBoundException("partition", 0., 1E8);
        }
        double prevRes;
        double curRes = calculateIntegral(function, limits, partition);
        do {
            prevRes = curRes;
            partition *= 2;
            curRes = calculateIntegral(function, limits, partition);
            if (partition > PARTITION_MAX_VALUE) {
                throw new ValueIsOutOfBoundException("partition", 1., PARTITION_MAX_VALUE);
            }
        } while (Math.abs(curRes - prevRes) / (Math.pow(2, SIMPSON_ACCURACY_ORDER) - 1) > accuracy);
        return IntegrationResult.of(curRes, partition);
    }

    private Double calculateIntegral(Function<Double, Double> function,
                                     IntegrationLimits limits,
                                     Integer partition) {
        double value = 0, h = (limits.right() - limits.left()) / partition;
        for (double x = limits.left() + h; x < limits.right(); x += 2 * h) {
            value += 4 * function.apply(x);
        }
        for (double x = limits.left() + 2 * h; x < limits.right(); x += 2 * h) {
            value += 2 * function.apply(x);
        }
        return (value + function.apply(limits.left()) + function.apply(limits.right())) * h / 3;
    }
}
