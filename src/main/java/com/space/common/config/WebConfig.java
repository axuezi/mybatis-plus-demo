package com.space.common.config;

import com.space.common.Interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * SpringMVC拦截器
 *
 * @author axue
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 返回体类型拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns("/**");
    }

}
