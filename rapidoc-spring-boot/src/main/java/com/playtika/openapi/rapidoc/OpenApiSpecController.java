package com.playtika.openapi.rapidoc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpenApiSpecController {

    private final String openApiSpecFile;

    public OpenApiSpecController(String openApiSpecFile) {
        this.openApiSpecFile = openApiSpecFile;
    }

    @RequestMapping("/v3/api-docs")
    public String openApiSpec() {
        return "redirect:/" + openApiSpecFile;
    }
}
