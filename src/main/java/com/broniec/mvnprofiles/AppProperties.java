package com.broniec.mvnprofiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class AppProperties {
    private String X;
    private String springVersion;
    private String version;
    private String basedir;
    private String filteredProperty;
    private String javaHome;
    private String osName;
    private String webXmlPath;
}
