package com.broniec.mvnprofiles;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class AppProperties {
    private String X;

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }
}
