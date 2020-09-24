package com.flash.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    //在这里控制访问路径跳转，就不用在controller中设置requestMapping
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/404.html").setViewName("404");
        registry.addViewController("/list.html").setViewName("list");
        registry.addViewController("/dashboard.html").setViewName("dashboard");


        //登录成功后跳转，地址栏不会显示出密码等信息
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean //注册组件到容器中
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login");
    }
}
