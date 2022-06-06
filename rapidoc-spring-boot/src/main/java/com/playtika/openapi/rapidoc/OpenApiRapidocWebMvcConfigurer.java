package com.playtika.openapi.rapidoc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class OpenApiRapidocWebMvcConfigurer implements WebMvcConfigurer {

    private final String openApiSpecFile;
    private final String openApiSpecPath;

    public OpenApiRapidocWebMvcConfigurer(String openApiSpecFile, String openApiSpecPath) {
        this.openApiSpecFile = openApiSpecFile;
        this.openApiSpecPath = openApiSpecPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/" + openApiSpecFile)
                .addResourceLocations("classpath:" + (openApiSpecPath.startsWith("/") ? openApiSpecPath : "/" + openApiSpecPath));

        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/swagger-ui.html");
    }

}
