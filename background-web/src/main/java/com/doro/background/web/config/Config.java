package com.doro.background.web.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan(basePackages = { "com.doro.background.web.controller", })
@Import({
	com.doro.background.service.config.Config.class,
	com.baofoo.config.Config.class
	})
@PropertySource("classpath:db.properties")
@ImportResource({ "classpath*:applicationContext-*.xml" })
public class Config {
	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		List<Filter> filters = new ArrayList<Filter>();
		Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
		slf4jLogFilter.setStatementExecutableSqlLogEnable(true);
		filters.add(slf4jLogFilter);
		ds.setProxyFilters(filters);
		return ds;
	}
}
