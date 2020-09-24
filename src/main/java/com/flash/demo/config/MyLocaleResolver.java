package com.flash.demo.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {



    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String lang = request.getParameter("lang");
        //默认的
        Locale locale = Locale.getDefault();
        //如果请求的链接携带了国际化的参数
        if(!StringUtils.isEmpty(lang)){
            String[] split = lang.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
