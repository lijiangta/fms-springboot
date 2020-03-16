package com.dxs.fms.config;

import com.dxs.fms.interceptor.LoginInterceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dxs
 * @date 2020/2/29 0029 15:00
 */
@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {

    /*@Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }*/
}
