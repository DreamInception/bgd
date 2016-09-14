package com.doro.background.dal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("com.doro.background.dal.entity")
@MapperScan("com.doro.background.dal.mapper")
public class Config {
	
}
