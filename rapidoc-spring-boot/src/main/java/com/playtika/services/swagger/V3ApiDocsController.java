package com.playtika.services.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class V3ApiDocsController {

    private final String openApiSpecFile;

    public V3ApiDocsController(String openApiSpecFile) {
        this.openApiSpecFile = openApiSpecFile;
    }

    @RequestMapping("/v3/api-docs")
    public String openApiSpec() {
        return "redirect:/" + openApiSpecFile;
    }
}
