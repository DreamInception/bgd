package com.doro.background.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.doro.background.service")
@EnableTransactionManagement(proxyTargetClass = true)
@Import({
	com.doro.background.dal.config.Config.class,
	com.doro.background.sina.config.Config.class
})
public class Config {

}
