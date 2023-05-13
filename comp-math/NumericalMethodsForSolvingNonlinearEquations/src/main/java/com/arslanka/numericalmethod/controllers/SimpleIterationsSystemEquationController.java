package com.arslanka.numericalmethod.controllers;

import java.io.NotActiveException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SystemOfEquations;
import com.arslanka.numericalmethod.models.dtos.EquationRequestDto;
import com.arslanka.numericalmethod.models.dtos.SystemOfTwoEquationsRootResultDto;
import com.arslanka.numericalmethod.services.SimpleIterationsSystemEquationMethodService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/simple-iterations/system")
public class SimpleIterationsSystemEquationController {

    private final SimpleIterationsSystemEquationMethodService simpleIterationsSystemEquationMethodService;

    @Autowired
    public SimpleIterationsSystemEquationController(final SimpleIterationsSystemEquationMethodService simpleIterationsSystemEquationMethodService) {
        this.simpleIterationsSystemEquationMethodService = simpleIterationsSystemEquationMethodService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    ResponseEntity<SystemOfTwoEquationsRootResultDto> solve(@RequestBody EquationRequestDto equationRequestDto) throws NotActiveException,
            ExecutionControl.NotImplementedException {
        BiFunction<BigDecimal, BigDecimal, BigDecimal> equation1 = (x1, x2) -> (
                x1.pow(2).multiply(BigDecimal.valueOf(-0.1))
                        .add(x2.pow(2).multiply(BigDecimal.valueOf(-0.2))
                                .add(BigDecimal.valueOf(0.3)
                                )
                        )
        );

        BiFunction<BigDecimal, BigDecimal, BigDecimal> equation2 = (x1, x2) -> (
                x1.pow(2).multiply(BigDecimal.valueOf(-0.2))
                        .add(x2.multiply(x1).multiply(BigDecimal.valueOf(-0.1)))
                        .add(BigDecimal.valueOf(0.7)
                        )
        );

        BiFunction<BigDecimal, BigDecimal, BigDecimal> jacobian = (x1, x2) -> (
                ((x1.multiply(BigDecimal.valueOf(-0.2))).multiply(x1.multiply(BigDecimal.valueOf(-0.1)))).subtract(
                        ((x1.multiply(BigDecimal.valueOf(-0.4)).add(x2.multiply(BigDecimal.valueOf(-0.1)))).multiply(x2.multiply(BigDecimal.valueOf(-0.4))))
                )
        );
        return ResponseEntity.ok(simpleIterationsSystemEquationMethodService.solveSystemOfEquations(
                new SystemOfEquations<>(List.of(equation1, equation2)),
                jacobian,
                new Segment<>(BigDecimal.valueOf(0), BigDecimal.valueOf(1)),
                new Segment<>(BigDecimal.valueOf(0), BigDecimal.valueOf(1)), BigDecimal.valueOf(0.01)).toDto()
        );
    }
}
