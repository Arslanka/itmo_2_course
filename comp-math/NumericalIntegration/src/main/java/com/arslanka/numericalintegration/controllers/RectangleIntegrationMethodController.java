package com.arslanka.numericalintegration.controllers;

import com.arslanka.numericalintegration.models.daos.IntegrationLimits;
import com.arslanka.numericalintegration.models.dtos.IntegrationRequestDto;
import com.arslanka.numericalintegration.models.dtos.IntegrationResultDto;
import com.arslanka.numericalintegration.services.RectangleIntegrationMethodService;
import com.arslanka.numericalintegration.utils.FunctionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3030")
@RestController
@RequestMapping("/rectangle-integration")
public class RectangleIntegrationMethodController {

    private static final Logger logger = LoggerFactory.getLogger(RectangleIntegrationMethodController.class);
    private final RectangleIntegrationMethodService rectangleIntegrationMethodService;

    @Autowired
    public RectangleIntegrationMethodController(RectangleIntegrationMethodService rectangleIntegrationMethodService) {
        this.rectangleIntegrationMethodService = rectangleIntegrationMethodService;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    public ResponseEntity<IntegrationResultDto> solve(@RequestBody IntegrationRequestDto integrationRequestDto) {
        logger.info(integrationRequestDto.toString());
        var result = rectangleIntegrationMethodService.solve(
                FunctionProvider.getFunctionByNumber(integrationRequestDto.numberOfFunction()),
                IntegrationLimits.of(
                        integrationRequestDto.integrationLimitsDto().left(),
                        integrationRequestDto.integrationLimitsDto().right()
                ),
                integrationRequestDto.partition(),
                integrationRequestDto.accuracy(),
                integrationRequestDto.rectangleMethodModificationDto().toDomain()
        );
        return ResponseEntity.ok(IntegrationResultDto.of(result.result(), result.partition()));
    }
}
