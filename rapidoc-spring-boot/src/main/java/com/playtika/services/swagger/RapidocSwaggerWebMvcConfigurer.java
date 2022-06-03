package com.playtika.services.swagger;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class RapidocSwaggerWebMvcConfigurer implements WebMvcConfigurer {

    private final String openApiSpecFile;
    private final String openApiSpecPath;

    public RapidocSwaggerWebMvcConfigurer(String openApiSpecFile, String openApiSpecPath) {
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
