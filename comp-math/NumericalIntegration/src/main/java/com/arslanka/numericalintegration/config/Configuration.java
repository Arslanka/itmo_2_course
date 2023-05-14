package com.arslanka.numericalintegration.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
