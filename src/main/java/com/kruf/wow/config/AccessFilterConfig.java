package com.kruf.wow.config;

import com.kruf.wow.filter.AccessLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessFilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AccessLogFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}
