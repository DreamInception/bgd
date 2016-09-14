package com.doro.background.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doro.background.web.filter.LoginFilter;

@Configuration
public class FilterConfig {
	@Autowired
	private LoginFilter loginFilter;

	@Bean
	public FilterRegistrationBean shallowEtagHeaderFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		System.err.print("*************************启动了过滤器*****************************");
		registration.setFilter(loginFilter);
		return registration;
	}

}
