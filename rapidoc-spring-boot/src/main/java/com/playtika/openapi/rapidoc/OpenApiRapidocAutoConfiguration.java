package com.playtika.openapi.rapidoc;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(value = "openapi.rapidoc.enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@Configuration
public class OpenApiRapidocAutoConfiguration {

    @Bean
    OpenApiSpecController openApiSpecController(OpenApiRapidocConfigurationProperties properties) {
        return new OpenApiSpecController(properties.getOpenApiSpec().getFileName());
    }

    @Bean
    OpenApiRapidocWebMvcConfigurer openApiRapidocWebMvcConfigurer(OpenApiRapidocConfigurationProperties properties) {
        return new OpenApiRapidocWebMvcConfigurer(properties.getOpenApiSpec().getFileName(), properties.getOpenApiSpec().getPath());
    }

    @Bean
    OpenApiRapidocConfigurationProperties openApiRapidocConfigurationProperties() {
        return new OpenApiRapidocConfigurationProperties();
    }

}
