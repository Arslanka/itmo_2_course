package com.arslanka.numericalmethod.controllers;

import java.math.BigDecimal;

import com.arslanka.numericalmethod.models.daos.Function;
import com.arslanka.numericalmethod.models.daos.Segment;
import com.arslanka.numericalmethod.models.daos.SimpleExpFunction;
import com.arslanka.numericalmethod.models.daos.SimplePowerFunction;
import com.arslanka.numericalmethod.models.dtos.EquationRequestDto;
import com.arslanka.numericalmethod.models.dtos.RootResultDto;
import com.arslanka.numericalmethod.services.SimpleIterationsMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/simple-iterations/equation")
public class SimpleIterationsMethodController {

    private final SimpleIterationsMethodService simpleIterationsMethodService;

    @Autowired
    public SimpleIterationsMethodController(SimpleIterationsMethodService simpleIterationsMethodService) {
        this.simpleIterationsMethodService = simpleIterationsMethodService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    ResponseEntity<RootResultDto> solve(@RequestBody EquationRequestDto equationRequestDto) {
        Function<BigDecimal> function;
        if (equationRequestDto.equationNumber() == 1) {
            function = new SimplePowerFunction(3)
                    .add(new SimplePowerFunction(1).multiply(BigDecimal.valueOf(-1)))
                    .add(BigDecimal.valueOf(4));
        } else {
            function = new SimpleExpFunction(BigDecimal.valueOf(2)).subtract(BigDecimal.valueOf(1));
        }
        return ResponseEntity.ok(simpleIterationsMethodService.solveEquation(
                function,
                new Segment<>(equationRequestDto.segment().left(), equationRequestDto.segment().right()),
                equationRequestDto.eps()
        ).toDto());
    }
}
