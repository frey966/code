package com.bfw.manage.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author study
 * @date 2019年08月16日
 */
@Configuration
public class UrlConfig {

    public static String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    @Value("${base.url}")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
