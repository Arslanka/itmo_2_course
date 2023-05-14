package com.arslanka.numericalintegration.controllers;

import com.arslanka.numericalintegration.models.daos.IntegrationLimits;
import com.arslanka.numericalintegration.models.dtos.IntegrationRequestDto;
import com.arslanka.numericalintegration.models.dtos.IntegrationResultDto;
import com.arslanka.numericalintegration.services.SimpsonIntegrationMethodService;
import com.arslanka.numericalintegration.utils.FunctionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpson-integration")
public class SimpsonIntegrationMethodController {

    private static final Logger logger =
            LoggerFactory.getLogger(SimpsonIntegrationMethodController.class);
    private final SimpsonIntegrationMethodService simpsonIntegrationMethodService;

    @Autowired
    public SimpsonIntegrationMethodController(SimpsonIntegrationMethodService simpsonIntegrationMethodService) {
        this.simpsonIntegrationMethodService = simpsonIntegrationMethodService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    public ResponseEntity<IntegrationResultDto> solve(@RequestBody IntegrationRequestDto integrationRequestDto) {
        logger.info(integrationRequestDto.toString());
        var result = simpsonIntegrationMethodService.solve(
                FunctionProvider.getFunctionByNumber(integrationRequestDto.numberOfFunction()),
                IntegrationLimits.of(
                        integrationRequestDto.integrationLimitsDto().left(),
                        integrationRequestDto.integrationLimitsDto().right()
                ),
                integrationRequestDto.partition(),
                integrationRequestDto.accuracy()
        );
        return ResponseEntity.ok(IntegrationResultDto.of(result.result(), result.partition()));
    }
}


