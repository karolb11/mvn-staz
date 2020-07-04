package com.broniec.mvnprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.env.Environment;

@Controller
public class HelloController {

    final
    AppProperties appProperties;
    final
    Environment env;

    public HelloController(AppProperties appProperties, Environment env) {
        this.appProperties = appProperties;
        this.env = env;
    }

    @GetMapping({"/", "/hello"})
    public String hello(
            Model model,
            @RequestParam(value="name", required=false, defaultValue="World") String name
    ) {

        model.addAttribute("name", name);
        model.addAttribute("javaHome", appProperties.getJavaHome());
        model.addAttribute("profile", appProperties.getX());
        model.addAttribute("springVersion", appProperties.getSpringVersion());
        model.addAttribute("version", appProperties.getVersion());
        model.addAttribute("basedir", appProperties.getBasedir());
        model.addAttribute("filteredProperty", appProperties.getFilteredProperty());
        return "hello";
    }
}
