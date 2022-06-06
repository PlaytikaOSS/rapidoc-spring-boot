package com.playtika.services.swagger;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(value = "openapi.rapidoc.enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@Configuration
public class RapidocSwaggerAutoConfiguration {

    @Bean
    V3ApiDocsController v3ApiDocsController(RapidocSwaggerConfigurationProperties properties) {
        return new V3ApiDocsController(properties.getOpenApiSpec().getFileName());
    }

    @Bean
    RapidocSwaggerWebMvcConfigurer rapidocSwaggerWebMvcConfigurer(RapidocSwaggerConfigurationProperties properties) {
        return new RapidocSwaggerWebMvcConfigurer(properties.getOpenApiSpec().getFileName(), properties.getOpenApiSpec().getPath());
    }

    @Bean
    RapidocSwaggerConfigurationProperties rapidocSwaggerConfigurationProperties() {
        return new RapidocSwaggerConfigurationProperties();
    }

}
