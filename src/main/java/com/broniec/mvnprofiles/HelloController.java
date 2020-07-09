package com.broniec.mvnprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContext;

@Controller
public class HelloController {

    final
    AppProperties appProperties;
    final
    Environment env;
    final
    ServletContext context;

    public HelloController(AppProperties appProperties, Environment env, ServletContext context) {
        this.appProperties = appProperties;
        this.env = env;
        this.context = context;
    }

    @GetMapping({"/", "/hello"})
    public String hello(
            Model model
    ) {
        String varX = context.getInitParameter("varX");
        model.addAttribute("javaHome", appProperties.getJavaHome());
        model.addAttribute("profile", appProperties.getX());
        model.addAttribute("webXmlPath", appProperties.getWebXmlPath());
        model.addAttribute("springVersion", appProperties.getSpringVersion());
        model.addAttribute("version", appProperties.getVersion());
        model.addAttribute("basedir", appProperties.getBasedir());
        model.addAttribute("filteredProperty", appProperties.getFilteredProperty());
        model.addAttribute("osName", appProperties.getOsName());
        model.addAttribute("varX", varX);
        return "hello";
    }

    @GetMapping({"/info"})
    public String info(
            Model model
    ) {
        return "info";
    }
}
