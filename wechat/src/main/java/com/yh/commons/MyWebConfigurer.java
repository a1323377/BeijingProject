package com.yh.commons;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }
}
