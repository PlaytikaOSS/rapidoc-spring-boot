package com.playtika.services.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@ConfigurationProperties("openapi.rapidoc")
public class RapidocSwaggerConfigurationProperties {

    /**
     * Enables/disables autoconfiguration for Rapidoc.
     */
    boolean enabled = true;

    OpenApiSpec openApiSpec = new OpenApiSpec();

    @Data
    @Validated
    public static class OpenApiSpec {

        /**
         * Path to the Open Api Spec file inside /src/main/resources folder.
         */
        @NotNull
        String path = "/openapi/";

        /**
         * Name of the Open Api Spec file.
         */
        @NotNull
        String fileName = "openapi.yaml";
    }
}
