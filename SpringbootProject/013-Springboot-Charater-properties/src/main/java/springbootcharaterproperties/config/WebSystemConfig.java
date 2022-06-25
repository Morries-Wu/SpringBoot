package springbootcharaterproperties.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootcharaterproperties.web.MyServlet;

@Configuration
public class WebSystemConfig {
    //注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        return bean;
    }


}
