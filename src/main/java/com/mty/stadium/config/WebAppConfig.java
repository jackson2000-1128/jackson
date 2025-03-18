package com.mty.stadium.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 注册拦截器
 * @author: mty
 **/
//注册拦截器
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**")//拦截的访问路径，拦截所有
                .excludePathPatterns("/static/**","/","/login","/logout","/register","/upload/*","/front/**");//排除的请求路径，排除静态资源路径
    }
}
