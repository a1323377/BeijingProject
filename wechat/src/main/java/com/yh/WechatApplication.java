package com.yh;

import com.yh.utils.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yh.mapper")
public class WechatApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(WechatApplication.class, args);
        ApplicationContextUtil.setApplicationContext(context);
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet){
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean=new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        return servletServletRegistrationBean;
    }
}
