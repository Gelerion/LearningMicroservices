package com.gelerion.learning.microservices.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * For refreshing beans, you need two things, one spring-boot-starter-actuator
 * dependency. This dependency will expose an HTTP endpoint for metrics,
 * health checks, HTTP trace, refresh etc. The second thing you need is to
 * add @RefreshScope annotation for beans you want it to be updated.
 */
@RefreshScope
@Component
@ConfigurationProperties
public class ImageServiceConfig {

    @Value("${imageservice.host}")
    private String host;

    @Value("${imageservice.port}")
    private String port;

    @Value("${imageservice.max_file_size}")
    private Integer maxFileSize;

    @Value("${imageservice.files.rename}")
    private Boolean renameFiles;

    @Value("${imageservice.files.resize}")
    private Boolean resizeFiles;

    @Value("${imageservice.files.add_watermark}")
    private Boolean addWatermark;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public Boolean getRenameFiles() {
        return renameFiles;
    }

    public Boolean getResizeFiles() {
        return resizeFiles;
    }

    public Boolean getAddWatermark() {
        return addWatermark;
    }

}