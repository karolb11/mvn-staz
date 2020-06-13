package com.broniec.mvnprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    AppProperties appProperties;

    @GetMapping({"/", "/hello"})
    public String hello(
            Model model,
            @RequestParam(value="name", required=false, defaultValue="World") String name
    ) {

        model.addAttribute("name", name);
        model.addAttribute("profile", appProperties.getX());
        return "hello";
    }
}
