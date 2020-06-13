package com.broniec.mvnprofiles;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MvnprofilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvnprofilesApplication.class, args);
    }

    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }

}
