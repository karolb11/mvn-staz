package com.broniec.mvnprofiles;

import com.broniec.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.env.Environment;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import java.util.Enumeration;

@Controller
public class HelloController implements ServletContextAware {

    final AppProperties appProperties;
    final Environment env;
    private ServletContext servletContext;

    public HelloController(AppProperties appProperties, Environment env) {
        this.appProperties = appProperties;
        this.env = env;
    }

    @GetMapping({"/", "/hello"})
    public String hello(
            Model model
    ) {
        model.addAttribute("javaHome", appProperties.getJavaHome());
        model.addAttribute("profile", appProperties.getX());
        model.addAttribute("webXmlPath", appProperties.getWebXmlPath());
        model.addAttribute("springVersion", appProperties.getSpringVersion());
        model.addAttribute("version", appProperties.getVersion());
        model.addAttribute("basedir", appProperties.getBasedir());
        model.addAttribute("filteredProperty", appProperties.getFilteredProperty());
        model.addAttribute("osName", appProperties.getOsName());
        model.addAttribute("myStaticMethodOutput", MyClass.myStaticMethodOutput());
        model.addAttribute("varX", servletContext.getInitParameter("varX"));

        return "hello";
    }

    @GetMapping({"/info"})
    public String info(
            Model model
    ) {
        return "info";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
