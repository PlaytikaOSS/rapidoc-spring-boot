package com.playtika.openapi.rapidoc;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = RapidocTest.TestConfig.class)
class RapidocTest {

    @LocalServerPort
    int port;

    @Test
    void redirectsToOriginalOpenApiSpecFileLocation() {
        RestAssured.given()
                .redirects()
                .follow(false)
                .port(port)
                .get("/v3/api-docs")
                .then()
                .assertThat()
                .statusCode(302)
                .header("Location", "http://localhost:" + port + "/openapi.yaml");
    }

    @Test
    void openApiSpecFileIsAvailableAfterRedirect() {
        RestAssured.given()
                .port(port)
                .get("/v3/api-docs")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/octet-stream");
    }

    @Test
    void swaggerUiIsAvailable() throws Exception {
        RestAssured.given()
                .port(port)
                .get("/swagger-ui.html")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }

    @EnableAutoConfiguration
    public static class TestConfig {

    }
}