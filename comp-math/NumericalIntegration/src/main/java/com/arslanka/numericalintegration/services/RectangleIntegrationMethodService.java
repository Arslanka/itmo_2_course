package com.arslanka.numericalintegration.services;

import java.util.function.Function;

import com.arslanka.numericalintegration.exceptions.NotImplementedException;
import com.arslanka.numericalintegration.exceptions.ValueIsOutOfBoundException;
import com.arslanka.numericalintegration.models.daos.IntegrationLimits;
import com.arslanka.numericalintegration.models.daos.IntegrationResult;
import com.arslanka.numericalintegration.models.daos.RectangleMethodModification;
import org.springframework.stereotype.Service;

@Service
public class RectangleIntegrationMethodService {

    private static final Integer LEFT_ACCURACY_ORDER = 1;
    private static final Integer MIDDLE_ACCURACY_ORDER = 2;
    private static final Integer RIGHT_ACCURACY_ORDER = 1;

    private static final Double EPS_MIN_VALUE = 1E-6;
    private static final Double PARTITION_MAX_VALUE = 1E8;

    public IntegrationResult solve(Function<Double, Double> function,
                                   IntegrationLimits limits,
                                   Integer partition,
                                   double accuracy,
                                   RectangleMethodModification modification
    ) {
        if (accuracy < EPS_MIN_VALUE) {
            throw new ValueIsOutOfBoundException("accuracy", EPS_MIN_VALUE, 1E8);
        }
        double prevRes;
        double curRes = calculateIntegral(function, limits, partition, modification);
        do {
            prevRes = curRes;
            partition *= 2;
            curRes = calculateIntegral(function, limits, partition, modification);
            if (partition > PARTITION_MAX_VALUE) {
                throw new ValueIsOutOfBoundException("partition", 1., PARTITION_MAX_VALUE);
            }
        } while (Math.abs(curRes - prevRes) / (Math.pow(2, accuracyOrderFromModification(modification)) - 1) > accuracy);
        return IntegrationResult.of(curRes, partition);
    }

    private Double calculateIntegral(Function<Double, Double> function,
                                     IntegrationLimits limits,
                                     Integer partition,
                                     RectangleMethodModification modification) {
        double value = 0, h = (limits.right() - limits.left()) / partition;
        switch (modification) {
            case LEFT -> {
                for (double x = limits.left(); x < limits.right(); x += h) {
                    value += function.apply(x);
                }
            }
            case RIGHT -> {
                for (double x = limits.left() + h; x <= limits.right(); x += h) {
                    value += function.apply(x);
                }
            }
            case MIDDLE -> {
                for (double x = limits.left() + h / 2; x <= limits.right(); x += h) {
                    value += function.apply(x);
                }
            }
            default -> throw new NotImplementedException("enum field %s".formatted(modification));
        }
        return value * h;
    }

    private Integer accuracyOrderFromModification(RectangleMethodModification modification) {
        switch (modification) {
            case LEFT -> {
                return LEFT_ACCURACY_ORDER;
            }
            case RIGHT -> {
                return RIGHT_ACCURACY_ORDER;
            }
            case MIDDLE -> {
                return MIDDLE_ACCURACY_ORDER;
            }
            default -> throw new NotImplementedException("enum field %s".formatted(modification));
        }
    }
}
