package com.memos.memosapp;

import com.memos.memosapp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")        // 拦截所有请求
                .excludePathPatterns(          // 以下接口不拦截
                        "/user/register",
                        "/user/login",
                        "/article/list",
                        "/comment/list"
                );
    }
}