package com.gwg.demo.config;

import com.gwg.demo.interceptor.OneInterceptor;
import com.gwg.demo.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * SpringMVC子容器
 *
 * 1.想要使用Java配置的方式搭建Springmvc,只需要将@EnableWebMvc添加到你的一个@Configuration class即可,使用这种方式后就
 * 不需要再配置web.xml文件了
 * 2.在这里为什么实现WebMvcConfigurer？
 * 想要以Java形式定制默认的配置，你可以简单的实现WebMvcConfigurer接口，根据需要配置，或者继承WebMvcConfigurerAdapter并重写需要的方法：
 */
@Configuration
@EnableWebMvc // 启用SpringMVC
@ComponentScan("com.gwg.demo.controller")//Controller添加到SpringMVC的容器中，在这里不能添加到Spring的容器中，否者服务找不到。SpringMVC的容器可以访问Spring的容器中的Bean
public class WebConfig extends WebMvcConfigurerAdapter {

    /** 视图解析器 */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/"); // 运行时的目录结构
        viewResolver.setSuffix(".jsp");
        //viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * Java形式注册拦截器：
     * @param interceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new OneInterceptor());
        interceptorRegistry.addInterceptor(new TwoInterceptor()).addPathPatterns("/test.html");

    }


    /**
     * 配置静态资源映射
     * @param resourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }


}