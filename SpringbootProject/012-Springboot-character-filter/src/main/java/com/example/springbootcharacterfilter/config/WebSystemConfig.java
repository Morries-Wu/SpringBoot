package com.example.springbootcharacterfilter.config;

import com.example.springbootcharacterfilter.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class WebSystemConfig {
    //注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        MyServlet myServlet = new MyServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(myServlet, "/myservlet");
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //使用框架中的过滤器类
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        //指定使用的编码方式
        filter.setEncoding("utf-8");
        //指定request,response都使用encoding的值
        filter.setForceEncoding(true);
        bean.setFilter(filter);
        //指定过滤的url地址
        bean.addUrlPatterns("/*");
        return bean;
    }
}
